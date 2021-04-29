package algoexpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DijkstraAlgorithm {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    int numberOfVertices = edges.length;
    int[] minDistances = new int[edges.length];
    Arrays.fill(minDistances, Integer.MAX_VALUE);
    minDistances[start] = 0;
    Set<Integer> visited = new HashSet<>();
    while (visited.size() != numberOfVertices) {
      int[] getVertexData = getVertexWithMinDistances(minDistances, visited);
      int vertex = getVertexData[0];
      int currentMinDistance = getVertexData[1];
      if (currentMinDistance == Integer.MAX_VALUE) {
        break;
      }
      visited.add(vertex);
      for (int[] edge : edges[vertex]) {
        int destination = edge[0];
        int distanceToDestination = edge[1];
        if (visited.contains(destination)) {
          continue;
        }
        int newPathDistance = currentMinDistance + distanceToDestination;
        int currentDestinationDistance = minDistances[destination];
        if (newPathDistance < currentDestinationDistance) {
          minDistances[destination] = newPathDistance;
        }
      }
    }
    int[] finalDistances = new int[minDistances.length];
    for (int i = 0; i < minDistances.length; i++) {
      int distance = minDistances[i];
      if (distance == Integer.MAX_VALUE) {
        finalDistances[i] = -1;
      } else {
        finalDistances[i] = distance;
      }
    }
    return finalDistances;
  }

  public int[] getVertexWithMinDistances(int[] distances, Set<Integer> visited) {
    int currentMinDistance = Integer.MAX_VALUE;
    int vertex = -1;
    for (int vertexIdx = 0; vertexIdx < distances.length; vertexIdx++) {
      int distance = distances[vertexIdx];
      if (visited.contains(vertexIdx)) {
        continue;
      }
      if (distance <= currentMinDistance) {
        vertex = vertexIdx;
        currentMinDistance = distance;
      }
    }
    return new int[] {vertex, currentMinDistance};
  }
}
