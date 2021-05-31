package book.epi_java.chapter11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSort {
  public static final Comparator<Student> compGPA =
      (a, b) -> {
        if (a.gradePointAverage != b.gradePointAverage)
          return Double.compare(a.gradePointAverage, b.gradePointAverage);
        return a.name.compareTo(b.name);
      };

  public static boolean searchStudent(
      List<Student> students, Student target, Comparator<Student> compGPA) {
    return Collections.binarySearch(students, target, compGPA) >= 0;
  }

  static class Student {
    public String name;
    public double gradePointAverage;

    public Student(String name, double gradePointAverage) {
      this.name = name;
      this.gradePointAverage = gradePointAverage;
    }
  }
}
