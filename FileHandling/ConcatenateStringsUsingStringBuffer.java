package FileHandling;

public class ConcatenateStringsUsingStringBuffer {
    public static String concatenate(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!", " How", " are", " you?"};
        String result = concatenate(input);
        System.out.println(result);
    }
}
