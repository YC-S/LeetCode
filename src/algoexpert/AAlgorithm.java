package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AAlgorithm {
  public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
    // Write your code here.
    List<List<Node>> nodes = initializeNodes(graph);
    Node startNode = nodes.get(startRow).get(startCol);
    Node endNode = nodes.get(endRow).get(endCol);
    startNode.distanceFromStart = 0;
    startNode.estimatedDistanceToEnd = calculateManhattanDistance(startNode, endNode);
    List<Node> nodesToVisitList = new ArrayList<>();
    nodesToVisitList.add(startNode);
    MinHeap nodesToVisit = new MinHeap(nodesToVisitList);

    while (!nodesToVisit.isEmpty()) {
      Node currentMinDistanceNode = nodesToVisit.remove();
      if (currentMinDistanceNode == endNode) {
        break;
      }
      List<Node> neighbors = getNeighboringNodes(currentMinDistanceNode, nodes);

      for (Node neighbor : neighbors) {
        if (neighbor.value == 1) continue;
        int tentativeDistanceToNeighbor = currentMinDistanceNode.distanceFromStart + 1;
        if (tentativeDistanceToNeighbor >= neighbor.distanceFromStart) continue;
        neighbor.cameFrom = currentMinDistanceNode;
        neighbor.distanceFromStart = tentativeDistanceToNeighbor;
        neighbor.estimatedDistanceToEnd =
            tentativeDistanceToNeighbor + calculateManhattanDistance(neighbor, endNode);
        if (!nodesToVisit.containsNode(neighbor)) {
          nodesToVisit.insert(neighbor);
        } else {
          nodesToVisit.update(neighbor);
        }
      }
    }
    return reconstructPath(endNode);
  }

  List<List<Node>> initializeNodes(int[][] graph) {
    List<List<Node>> nodes = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
      List<Node> nodeList = new ArrayList<>();
      nodes.add(nodeList);
      for (int j = 0; j < graph[i].length; j++) {
        nodes.get(i).add(new Node(i, j, graph[i][j]));
      }
    }
    return nodes;
  }

  int calculateManhattanDistance(Node currentNode, Node endNode) {
    int currentRow = currentNode.row;
    int currentCol = currentNode.col;
    int endRow = endNode.row;
    int endCol = endNode.col;
    return Math.abs(currentRow - endRow) + Math.abs(currentCol - endCol);
  }

  List<Node> getNeighboringNodes(Node node, List<List<Node>> nodes) {
    List<Node> neighbors = new ArrayList<>();
    int numRows = nodes.size();
    int numCols = nodes.get(0).size();
    int row = node.row;
    int col = node.col;
    if (row < numRows - 1) {
      neighbors.add(nodes.get(row + 1).get(col));
    }
    if (row > 0) {
      neighbors.add(nodes.get(row - 1).get(col));
    }
    if (col < numCols - 1) {
      neighbors.add(nodes.get(row).get(col + 1));
    }
    if (col > 0) {
      neighbors.add(nodes.get(row).get(col - 1));
    }
    return neighbors;
  }

  int[][] reconstructPath(Node endNode) {
    if (endNode.cameFrom == null) {
      return new int[][] {};
    }
    Node currentNode = endNode;
    List<List<Integer>> path = new ArrayList<>();
    while (currentNode != null) {
      List<Integer> nodeData = new ArrayList<>();
      nodeData.add(currentNode.row);
      nodeData.add(currentNode.col);
      path.add(nodeData);
      currentNode = currentNode.cameFrom;
    }
    int[][] res = new int[path.size()][2];
    for (int i = 0; i < res.length; i++) {
      res[i][0] = path.get(res.length - 1 - i).get(0);
      res[i][1] = path.get(res.length - 1 - i).get(1);
    }
    return res;
  }

  static class Node {
    String id;
    int row;
    int col;
    int value;
    int distanceFromStart;
    int estimatedDistanceToEnd;
    Node cameFrom;

    Node(int row, int col, int value) {
      this.id = String.valueOf(row) + '-' + col;
      this.row = row;
      this.col = col;
      this.value = value;
      this.distanceFromStart = Integer.MAX_VALUE;
      this.estimatedDistanceToEnd = Integer.MAX_VALUE;
      this.cameFrom = null;
    }
  }

  static class MinHeap {
    List<Node> heap = new ArrayList<Node>();
    Map<String, Integer> nodePositionsInHeap = new HashMap<>();

    public MinHeap(List<Node> array) {
      for (int i = 0; i < array.size(); i++) {
        Node node = array.get(i);
        nodePositionsInHeap.put(node.id, i);
      }
      heap = buildHeap(array);
    }

    List<Node> buildHeap(List<Node> array) {
      int firstParentIdx = (array.size() - 2) / 2;
      for (int currentIdx = firstParentIdx + 1; currentIdx >= 0; currentIdx--) {
        siftDown(currentIdx, array.size() - 1, array);
      }
      return array;
    }

    boolean isEmpty() {
      return heap.size() == 0;
    }

    void siftDown(int currentIdx, int endIdx, List<Node> array) {
      int childOneIdx = currentIdx * 2 + 1;
      while (childOneIdx <= endIdx) {
        int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
        int idxToSwap;
        if (childTwoIdx != -1
            && array.get(childTwoIdx).estimatedDistanceToEnd
                < heap.get(childOneIdx).estimatedDistanceToEnd) {
          idxToSwap = childTwoIdx;
        } else {
          idxToSwap = childOneIdx;
        }
        if (array.get(idxToSwap).estimatedDistanceToEnd
            < array.get(currentIdx).estimatedDistanceToEnd) {
          swap(currentIdx, idxToSwap);
          currentIdx = idxToSwap;
          childOneIdx = currentIdx * 2 + 1;
        } else {
          return;
        }
      }
    }

    void siftUp(int currentIdx) {
      int parentIdx = (currentIdx - 1) / 2;
      while (currentIdx > 0
          && heap.get(currentIdx).estimatedDistanceToEnd
              < heap.get(parentIdx).estimatedDistanceToEnd) {
        swap(currentIdx, parentIdx);
        currentIdx = parentIdx;
        parentIdx = (currentIdx - 1) / 2;
      }
    }

    Node remove() {
      if (isEmpty()) {
        return null;
      }

      swap(0, heap.size() - 1);
      Node node = heap.get(heap.size() - 1);
      heap.remove(heap.size() - 1);
      nodePositionsInHeap.remove(node.id);
      siftDown(0, heap.size() - 1, heap);
      return node;
    }

    void insert(Node node) {
      heap.add(node);
      nodePositionsInHeap.put(node.id, heap.size() - 1);
      siftUp(heap.size() - 1);
    }

    void swap(int i, int j) {
      nodePositionsInHeap.put(heap.get(i).id, j);
      nodePositionsInHeap.put(heap.get(j).id, i);
      Node temp = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, temp);
    }

    boolean containsNode(Node node) {
      return nodePositionsInHeap.containsKey(node.id);
    }

    void update(Node node) {
      siftUp(nodePositionsInHeap.get(node.id));
    }
  }
}
