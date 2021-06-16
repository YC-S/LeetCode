package all_problems;

public class P1899_MergeTripletsToFormTargetTriplet {
  public boolean mergeTriplets(int[][] triplets, int[] target) {
    int[] hopefulTriplet = new int[3];
    for (int[] triplet : triplets) {
      if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
        continue;
      } else {
        hopefulTriplet[0] = Math.max(hopefulTriplet[0], triplet[0]);
        hopefulTriplet[1] = Math.max(hopefulTriplet[1], triplet[1]);
        hopefulTriplet[2] = Math.max(hopefulTriplet[2], triplet[2]);
      }
    }

    return hopefulTriplet[0] == target[0]
        && hopefulTriplet[1] == target[1]
        && hopefulTriplet[2] == target[2];
  }
}
