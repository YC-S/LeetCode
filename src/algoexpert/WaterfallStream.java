package algoexpert;

public class WaterfallStream {
  public double[] waterfallStream(double[][] array, int source) {
    double[] rowAbove = array[0];
    rowAbove[source] = -1;
    for (int row = 1; row < array.length; row++) {
      double[] currentRow = array[row];
      for (int idx = 0; idx < rowAbove.length; idx++) {
        double valueAbove = rowAbove[idx];
        boolean hasWaterAbove = valueAbove < 0;
        boolean hasBlock = currentRow[idx] == 1.0;
        if (!hasWaterAbove) {
          continue;
        }
        if (!hasBlock) {
          currentRow[idx] += valueAbove;
          continue;
        }
        double splitWater = valueAbove / 2;
        int rightIdx = idx;
        while (rightIdx + 1 < rowAbove.length) {
          rightIdx++;
          if (rowAbove[rightIdx] == 1.0) {
            break;
          }
          if (currentRow[rightIdx] != 1) {
            currentRow[rightIdx] += splitWater;
            break;
          }
        }
        int leftIdx = idx;
        while (leftIdx - 1 >= 0) {
          leftIdx--;
          if (rowAbove[leftIdx] == 1.0) {
            break;
          }
          if (currentRow[leftIdx] != 1.0) {
            currentRow[leftIdx] += splitWater;
            break;
          }
        }
      }
      rowAbove = currentRow;
    }
    double[] finalPercentages = new double[rowAbove.length];
    for (int idx = 0; idx < rowAbove.length; idx++) {
      double num = rowAbove[idx];
      if (num == 0) {
        finalPercentages[idx] = num;
      } else {
        finalPercentages[idx] = (num * -100);
      }
    }
    return finalPercentages;
  }
}
