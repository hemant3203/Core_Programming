package Practice_problem_01;

public class q8 {
     public static void main(String[] args) {
        double costPrice = 129;
        double sellingPrice = 191;
        double profit = sellingPrice - costPrice;
        double profitPercent = (profit / costPrice) * 100;
        System.out.printf("The Cost Price is INR %.2f and the Selling Price is INR %.2f\nThe Profit is INR %.2f and the Profit Percentage is %.2f\n", costPrice, sellingPrice, profit, profitPercent);
    }
}
