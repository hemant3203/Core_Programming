package Regex;
import java.util.regex.*;
public class validEmail{
    public static void main(String[] args) {
        String regex="^[a-zA-Z0-9_.]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
        Pattern p=Pattern.compile(regex);
        String emails[]={"hemant@gmail.com","gla@123@.com","yahoo@google.com","ok@google.com"};
        for(String s:emails){
            Matcher m=p.matcher(s);
            System.out.println(s+" is Valid:"+m.matches());
        }
    }
}