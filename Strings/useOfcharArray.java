package Strings;

import java.util.Scanner;

public class useOfcharArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char [] arr1 = getCharacterWithoutUsingcharArray(str);
        System.out.println(arr1.toString());
        char [] arr2 = str.toCharArray();
        System.out.println(arr2.toString());

        System.out.println(compare(arr1,arr2));

        sc.close();
    }
    public static char[] getCharacterWithoutUsingcharArray(String str){
        char[] arr = new char[str.length()];
        for(int i = 0;i<str.length();i++){
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compare(char [] arr1, char [] arr2){
        for(int i = 0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
