package all_problems;

public class P774_MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        int count, N = stations.length;
        double left = 0, right = stations[N - 1] - stations[0], mid;

        while (left + 1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i)
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            if (count > K) left = mid;
            else right = mid;
        }
        return right;
    }
}
