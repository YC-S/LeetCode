package data_structures.treemap;

import java.util.TreeMap;

public class TreeMapDemo {
  public static void main(String[] args) {
    TreeMap<Integer, String> treemap = new TreeMap<>();
    treemap.put(10, "Geek");
    treemap.put(15, "4");
    treemap.put(20, "Geek");
    treemap.put(25, "Welcome");
    treemap.put(30, "You");
    System.out.println("The original map is: " + treemap);
    System.out.println("The tail map is: " + treemap.tailMap(15));
    System.out.println("The tail map except 15 is: " + treemap.tailMap(15, false));
  }
}
