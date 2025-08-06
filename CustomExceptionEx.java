// import java.util.*;
// class CustomException extends Exception{
//   public CustomException(String message){
//   super(message);
//   }
// }


// public class CustomExceptioncustom {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         try{
//             System.out.println("Enter the age :");
//             validateAge(sc.nextInt());
//             System.out.println("Age is Valid");
//         }
//         catch(CustomException e){
//         System.out.println("Caugth Custom Exception:"+e.getMessage());
//         }
//         sc.close();
//     }

// public static void validateAge(int age) throws CustomException{
//     if(age<18){
//         throw new CustomException("Age must be above 18");
//     }
// }
// }


import java.util.*;
class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}


public class CustomExceptionEx{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter the age ");
            int age=sc.nextInt();
            validateAge(age);
            System.out.println("Age is Valid");
        }
        catch(CustomException e){
            System.out.println("Got an Exception: "+e.getMessage());
        }
        sc.close();
    }

    public static void validateAge(int age)throws CustomException{
        if(age<18){
            throw new CustomException("Age is Not valid ");
        }

    }
}