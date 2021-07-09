public class main5 {
    public static void main(String[] args){
        MyClass myClass = new MyClass();
        MyClass iroha = new MyClass();
        MyClass sensei = new MyClass();

        iroha.myname = "いろは";
        sensei.myname = "センセイ";
        
        myClass.hello();
        iroha.hello();
        sensei.hello();
    }
}
