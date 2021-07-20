package check;
import constants.Constants;

public class Check {
		private String firstName;
		private String lastName;
		
		public Check(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		

    public  String printName(String fristName,String LastName) {
        	return firstName + lastName;
        	
    }	
    public static void main(String[] args) {
    	String firstName = "YUSUKE";
    	String lastName = "FUKUDA";
    	Check a = new Check(firstName, lastName);
    	System.out.println(a.printName(firstName, lastName));
        System.out.println();   
        
        
        
        Pet c = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HGE);
        c.introduce();
        
        Pet b = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
        b.introduce();
       
       
        
    }
    
    
    
    
}

	


