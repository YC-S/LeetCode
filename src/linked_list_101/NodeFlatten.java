/*
 * Copyright (c) 2020. Yuanchen
 */

package linked_list_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/27
 */
public class NodeFlatten {

  public int val;
  public NodeFlatten next;
  public NodeFlatten prev;
  public NodeFlatten child;

  public NodeFlatten(int val) {
    this.val = val;
  }
}
