package Methods;
import java.util.*;

public class OTPGenerator {
    public static String generateOTP() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) sb.append(rand.nextInt(10));
        return sb.toString();
    }

    public static boolean areOTPUnique(String[] otps) {
        Set<String> set = new HashSet<>(Arrays.asList(otps));
        return set.size() == otps.length;
    }

    public static void main(String[] args) {
        String[] otps = new String[10];
        for (int i = 0; i < 10; i++) otps[i] = generateOTP();
        for (String otp : otps) System.out.println(otp);
        System.out.println("All Unique: " + areOTPUnique(otps));
    }
}
