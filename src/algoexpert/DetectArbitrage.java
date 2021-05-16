package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectArbitrage {
  public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
    ArrayList<ArrayList<Double>> logExchangeRates = convertToLogMatrix(exchangeRates);
    return foundNegativeWeightCycle(logExchangeRates, 0);
  }

  public boolean foundNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int start) {
    double[] distancesFromStart = new double[graph.size()];
    Arrays.fill(distancesFromStart, Double.MAX_VALUE);
    distancesFromStart[start] = 0;

    for (int unused = 0; unused < graph.size(); unused++) {
      if (!relaxEdgesAndUpdateDistance(graph, distancesFromStart)) {
        return false;
      }
    }

    return relaxEdgesAndUpdateDistance(graph, distancesFromStart);
  }

  public boolean relaxEdgesAndUpdateDistance(
      ArrayList<ArrayList<Double>> graph, double[] distances) {
    boolean updated = false;
    for (int sourceIdx = 0; sourceIdx < graph.size(); sourceIdx++) {
      ArrayList<Double> edges = graph.get(sourceIdx);
      for (int destinationIdx = 0; destinationIdx < edges.size(); destinationIdx++) {
        double edgeWeight = edges.get(destinationIdx);
        double newDistanceToDestination = distances[sourceIdx] + edgeWeight;
        if (newDistanceToDestination < distances[destinationIdx]) {
          updated = true;
          distances[destinationIdx] = newDistanceToDestination;
        }
      }
    }
    return updated;
  }

  public ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> matrix) {
    ArrayList<ArrayList<Double>> newMatrix = new ArrayList<>();
    for (int row = 0; row < matrix.size(); row++) {
      ArrayList<Double> rates = matrix.get(row);
      newMatrix.add(new ArrayList<Double>());
      for (Double rate : rates) {
        newMatrix.get(row).add(-Math.log10(rate));
      }
    }
    return newMatrix;
  }
}
