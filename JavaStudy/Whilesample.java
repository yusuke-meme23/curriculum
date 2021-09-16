import java.util.Scanner; 

public class Whilesample { 
  public static void main(String[] args) { 
    int inputNum; // ユーザ入力値 
    int sum = 0; // 合計値 

    // ユーザ入力読み込みオブジェクトを生成 
    Scanner scanner = new Scanner(System.in); 

    // 初回の数値入力 
    System.out.print("数値入力（-1で終了）："); 
    inputNum = scanner.nextInt(); 

    // ユーザから「-1」が入力されるまで、入力された数値をsum変数に加算 
    while (inputNum != -1) { 
      // 入力値をsumに加算 
      sum += inputNum; 

      // ２回目以降の数値入力 
      System.out.print("数値入力（-1で終了）："); 
      inputNum = scanner.nextInt(); 
    } 

    // 合計値を表示 
    System.out.println("入力された数値の合計は " + sum + " です。"); 
  } 
}