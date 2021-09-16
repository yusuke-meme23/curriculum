class FizzBuzz{ 
   public static void main(String[] args){ 
      //1から100までの整数のループ 
      for(int i = 1; i <= 100; ++i){ 

         //3と5の両方で割り切れるときはFizzBuzzを表示 
         if(i % 3 == 0 && i % 5 == 0){ 
            System.out.println("FizzBuzz"); 

         //3で割り切れるときはFizzを表示 
         }else if(i % 3 == 0){ 
            System.out.println("Fizz"); 

         //5で割り切れるときはBuzzを表示 
         }else if(i % 5 == 0){ 
            System.out.println("Buzz"); 

         //それ以外の時は変数 i を表示 
         }else{ 
            System.out.println(i); 
         } 
      } 
   } 
}