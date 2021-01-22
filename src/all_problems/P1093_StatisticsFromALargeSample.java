package all_problems;

public class P1093_StatisticsFromALargeSample {
    public double[] sampleStats(int[] count) {
        int l = 0, r = 255, nl = 0, nr = 0, mn = 255, mx = -1, mid1 = 0, mid2 = 0, mode = 0;
        double avg = 0, mid = 0;
        while (l <= r) {
            while (count[l] == 0) l++;
            while (count[r] == 0) r--;
            if (nl < nr) {
                avg += count[l] * l;
                nl += count[l];
                if (count[l] > count[mode]) mode = l;
                mn = Math.min(mn, l);
                mid1 = l;
                l++;
            } else {
                avg += count[r] * r;
                nr += count[r];
                if (count[r] > count[mode]) mode = r;
                mx = Math.max(mx, r);
                mid2 = r;
                r--;
            }
        }
        avg /= (nl + nr);
        // Find median
        if (nl < nr) mid = mid2;
        else if (nl > nr) mid = mid1;
        else mid = (double) (mid1 + mid2) / 2;
        return new double[]{mn, mx, avg, mid, mode};
    }
}
