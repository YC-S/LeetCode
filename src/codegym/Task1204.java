package codegym;

public class Task1204 {
  public static void main(String[] args) {
    printObjectType(new Cat());
    printObjectType(new Bird());
    printObjectType(new Lamp());
    printObjectType(new Cat());
    printObjectType(new Dog());
  }

  public static void printObjectType(Object o) {
    System.out.println(o.getClass().getName().substring("codegym.Task1204$".length()));
  }

  public static class Cat {}

  public static class Dog {}

  public static class Bird {}

  public static class Lamp {}
}
