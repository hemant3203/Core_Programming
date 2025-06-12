package Practice_problem_01;
public class q3 {
    public static void main(String[] args) {
        // Radius of Earth in km
        double radiusKm = 6378;
        // Volume of a sphere = (4/3) * pi * r^3
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        // Convert cubic kilometers to cubic miles (1 km = 0.621371 miles)
        double radiusMiles = radiusKm * 0.621371;
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);
        System.out.printf("The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f\n", volumeKm3, volumeMiles3);
    }
}
