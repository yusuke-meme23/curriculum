package com.example.security.springsecurity.account;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Domain Objectのコレクションのような位置づけであり、Domain Objectの問い合わせや、作成、更新、削除のようなCRUD処理を担う。
//この層では、インタフェースのみ定義され、実体は、インフラストラクチャ層のRepositoryImplで実装されるため、
//どのようなデータアクセスが行われているかについての情報は持たない。
//問２－１ リポジトリを作成するアノテーションを記述
@Repository
//ユーザーネームの検索
public interface AccountRepository extends CrudRepository<Account, Long> {
    public Account findByUsername(String username);
    public List<Account> findAll();
}
