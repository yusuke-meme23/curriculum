//フレームワークの力を借りて、データベースの実装を意識せずにデータ構造を取得することができるもの
package com.example.security.springsecurity.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//実行時に宣言した各フィールド変数がカラムとして作成される
//問１－１ DB設計に必要なアノテーションを記述
//データの入れ物となるクラスを作成
@Entity
@Table(name="accounts")
//インターフェイスを実装したクラスは、インターフェイスで宣言された抽象メソッドを呼び出せるようになります。そして、クラスをそのインターフェイスの型としても扱えることです。
public class Account implements UserDetails {

	private static final long serialVersionUID = 1L;

	//権限は一般ユーザ、マネージャ、システム管理者の３種類とする 定数をまとめて管理するもの
	public enum Authority {ROLE_USER, ROLE_MANAGER, ROLE_ADMIN}

	//問１－２ プライマリーキーを設定するアノテーションを記述
	@Id
	//プロパティがユニークキーであるかどうかを指定する属性
	//データベースのカラムにnull値を指定できるかどうかを指定する属性
	@Column(nullable = false, unique = true)
	//カラム名の指定
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private String mailAddress;

	//@Columnで指定したカラムをSQLのINSERT文に含むかどうかを指定する属性。true 含む　false 含まない
	@Column(nullable = false)
	private boolean mailAddressVerified;

	@Column(nullable = false)
	private boolean enabled;

	//データベースにDATEだけを保存したい場合、TemporalTypeを使うことができる
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	// roleは複数管理できるように、Set<>で定義。
	//データベースからエンティティの情報を読み込むときに，関連するフィールドやエンティティの情報を読み込みます。
	@ElementCollection(fetch = FetchType.EAGER)
	//@Enumeratedは見ての通り、対象に付与するだけで登録・復元が指定した通りとなる
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Set<Authority> authorities;

	// JPA requirement
	protected Account() {}

	//コンストラクタ　指定したユーザー名、パスワード、メールアドレスを持つAccountオブジェクトの作成
	public Account(String username, String password, String mailAddress) {
		this.username = username;
		this.password = password;
		this.mailAddress = mailAddress;
		this.mailAddressVerified = false;
		this.enabled = true;
		this.authorities = EnumSet.of(Authority.ROLE_USER);
	}

	//登録時に、日時を自動セットする
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}

	//admin権限チェック
	public boolean isAdmin() {
		return this.authorities.contains(Authority.ROLE_ADMIN);
	}

	//admin権限セット
	public void setAdmin(boolean isAdmin) {
		if (isAdmin) {
			this.authorities.add(Authority.ROLE_MANAGER);
			this.authorities.add(Authority.ROLE_ADMIN);
		} else {
			this.authorities.remove(Authority.ROLE_ADMIN);
		}
	}

	//管理者権限を保有しているか？
	public boolean isManager() {
		return this.authorities.contains(Authority.ROLE_MANAGER);
	}

	//管理者権限セット
	public void setManager(boolean isManager) {
		if (isManager) {
			this.authorities.add(Authority.ROLE_MANAGER);
		} else {
			this.authorities.remove(Authority.ROLE_MANAGER);
			this.authorities.remove(Authority.ROLE_ADMIN);
		}
	}

	@Override
	//ユーザー権限情報を取得している
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Authority authority : this.authorities) {
			authorities.add(new SimpleGrantedAuthority(authority.toString()));
		}
		return authorities;
	}

	@Override
	//クラス継承の際に親クラスのメソッドと同じ名前のメソッドを子クラスで定義し直す
	//アカウントが期限切れでないかを取得する
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	//アカウントがロックされてないかを取得する
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	//アカウントが認証期限切れでないかを取得する
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	//ユーザー名を取得する
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	//パスワード名を取得する
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	//アカウントが利用可能かを取得する
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public boolean isMailAddressVerified() {
		return mailAddressVerified;
	}
	public void setMailAddressVerified(boolean mailAddressVerified) {
		this.mailAddressVerified = mailAddressVerified;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
}