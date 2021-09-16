public class Main {

    public static void main(String[] args) {

        // plusメソッドの足し算に使用する変数と値を設定する
        int x = 10;
        int y = 5;

        // plusメソッドに上記で設定したxとyを渡して足し算してもらい、変数resultに格納する
        int result = plus(x, y);

        // 足し算の結果をprintメソッドに渡して表示してもらう
        print(result);

    }

    /** plusメソッド：渡された引数を元に足し算をして結果を返してくれる
     *  足し算した結果を他の処理に用いたい為、戻り値ありにしています
     */
    public static int plus(int x, int y) {
        // 受け取ったxとyを足し算して結果を返してあげる
        return x + y;
    }

    /** printメソッド：渡された引数を表示する
     *  ここでは表示をするのみで、結果を他に用いるわけではないので戻り値なしにしています
     */
    public static void print(int result) {
        System.out.println(result);
    }
}