package algoexpert;

import java.util.ArrayList;

public class LargestRectangleUnderSkyline {
  public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
    // Write your code here.
    int maxArea = 0;
    for (int pillarIdx = 0; pillarIdx < buildings.size(); pillarIdx++) {
      int currentHeight = buildings.get(pillarIdx);
      int furthestLeft = pillarIdx;
      while (furthestLeft > 0 && buildings.get(furthestLeft - 1) >= currentHeight) {
        furthestLeft -= 1;
      }
      int furthestRight = pillarIdx;
      while (furthestRight < buildings.size() - 1
          && buildings.get(furthestRight + 1) >= currentHeight) {
        furthestRight += 1;
      }
      int areaWithCurrentBuilding = (furthestRight - furthestLeft + 1) * currentHeight;
      maxArea = Math.max(areaWithCurrentBuilding, maxArea);
    }
    return maxArea;
  }
}
