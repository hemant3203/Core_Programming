package Practice_problem_01;

import java.util.Scanner;

public class q24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String fromCity = sc.next();
        String viaCity = sc.next();
        String toCity = sc.next();
        int fromToVia = sc.nextInt();
        int viaToFinalCity = sc.nextInt();
        int timeFromToVia = sc.nextInt();
        int timeViaToFinalCity = sc.nextInt();
        int totalDistance = fromToVia + viaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;
        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity + " is " + totalDistance + " km and the Total Time taken is " + totalTime + " minutes");
    sc.close();
    }
}
