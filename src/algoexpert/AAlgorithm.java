package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AAlgorithm {
  public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
    // Write your code here.
    return new int[][] {};
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
