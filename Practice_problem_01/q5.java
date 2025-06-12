package Practice_problem_01;

public class q5 {
     public static void main(String[] args) {
        double fee = 125000;
        double discountPercent = 10;
        // Calculating discount and final fee
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f\n", discount, finalFee);
    }
}
