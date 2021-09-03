package controller;
 
/**
 * 社員情報管理コントローラー
 */
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeBean;
import service.EmployeeService;

//import service.EmployeeService;
 
public class EmployeeController extends HttpServlet {
 public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 //例外処理
 try {
  // 問① index.htmlから送信されたIDとPassWordの値を取得できるように修正しましょう。
 String id = request.getParameter("id");
 String password = request.getParameter("pass");
 
 /*
 * IDとPassWordと元に、社員情報を検索する関数の呼び出し、結果をJSPに渡す処理
 * ※ EmployeeBeanとEmployeeServiceをimportするのを忘れないでください。
 */
 
  // 問② EmployeeServiceクラスをインスタンス化する。
 EmployeeService es = new EmployeeService();
 
  // 問③ EmployeeBeanに、EmployeeServiceよりsearch関数を呼び出し、返り値を格納する。
 EmployeeBean eb = es.search(id,password);
 
  // 問④ nullの部分に適切な引数をセットする。渡すデータの前処理。クラス名、実際入れる値or変数
 request.setAttribute("EmployeeBean", eb);
 
 } catch (Exception e) {
//エラーが発生した箇所と原因を確認することができる
 e.printStackTrace();
 } finally {
 ServletContext context = this.getServletContext();
 //移動したい場所のアドレス
 RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
 //画面移動。次のページにいく
 dispatcher.forward(request, response);
 }
 }
}
