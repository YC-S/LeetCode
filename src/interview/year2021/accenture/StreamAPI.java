package interview.year2021.accenture;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
  private static final Employee[] arrayOfEmployees = {
    new Employee(1, "Jeff Bezos", 100000),
    new Employee(2, "Bill Gates", 200000),
    new Employee(3, "Mark Zuckerberg", 300000),
  };

  public static void main(String[] args) {
    System.out.println(Stream.of(arrayOfEmployees));
    Stream.Builder<Employee> employeeStreamBuilder = Stream.builder();
    employeeStreamBuilder.accept(arrayOfEmployees[0]);
    employeeStreamBuilder.accept(arrayOfEmployees[1]);
    employeeStreamBuilder.accept(arrayOfEmployees[2]);
    Integer[] employeeId = {1, 2, 3};
    List<Employee> employees = Stream.of(arrayOfEmployees).collect(Collectors.toList());
    List<Employee> filteredEmployees =
        Stream.of(arrayOfEmployees)
            .filter(e -> e != null)
            .filter(e -> e.getSalary() > 200000)
            .collect(Collectors.toList());
    System.out.println(employees);
    System.out.println(filteredEmployees);
  }

  static class Employee {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
      this.id = id;
      this.name = name;
      this.salary = salary;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getSalary() {
      return salary;
    }

    public void setSalary(int salary) {
      this.salary = salary;
    }
  }
}
