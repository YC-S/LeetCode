package all_problems;

public class P1603_DesignParkingSystem {
    int[] count;

    public P1603_DesignParkingSystem(int big, int medium, int small) {
        count = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return count[carType - 1]-- > 0;
    }
}
