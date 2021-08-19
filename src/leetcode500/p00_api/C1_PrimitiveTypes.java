package leetcode500.p00_api;

import java.util.Random;

public class C1_PrimitiveTypes {
  public static void main(String[] args) {
    // Bitwise parameters
    System.out.println(6 & 4); // 4
    System.out.println(1 | 2); // 3
    System.out.println(8 >> 1); // 4
    System.out.println(-16 >>> 2); // 1073741820
    System.out.println(1 << 10); // 1024
    System.out.println(~0); // 1
    System.out.println(15 ^ 0); // 15
    System.out.println(15 ^ 1); // 14

    // constants
    System.out.println(Integer.MAX_VALUE); // 2147483647
    System.out.println(Integer.MIN_VALUE); // -2147483648
    System.out.println(Long.MAX_VALUE); // 9223372036854775807
    System.out.println(Long.MIN_VALUE); // -9223372036854775808
    System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308
    System.out.println(Double.MIN_VALUE); // 4.9E-324
    System.out.println(Float.MAX_VALUE); // 3.4028235E38
    System.out.println(Float.MIN_VALUE); // 1.4E-45
    System.out.println(Double.SIZE); // 64
    System.out.println(Integer.SIZE); // 32
    System.out.println(Float.SIZE); // 32
    System.out.println(Character.SIZE); // 16
    System.out.println(Byte.SIZE); // 8

    // box types, especially factories
    System.out.println(Double.valueOf("1.23")); // 1.23
    System.out.println(Boolean.valueOf(true)); // true
    System.out.println(Integer.parseInt("42")); // 42
    System.out.println((float) -1.23); // -1.23

    // box-type static methods for comparing values
    System.out.println(Double.compare(2.34, 1.23)); // 1
    System.out.println(Integer.compare(3, 5)); // -1
    System.out.println(Character.compare('a', 'a')); // 0

    // key methods in Math
    System.out.println(Math.abs(-34.5)); // 34.5
    System.out.println(Math.ceil(2.17)); // 3.0
    System.out.println(Math.floor(2.17)); // 2.0
    System.out.println(Math.min(-3, -5)); // -5
    System.out.println(Math.max(2, 100)); // 100
    System.out.println(Math.pow(2, 3)); // 8.0
    System.out.println(Math.sqrt(225)); // 15.0

    // Interconvert integers, characters and strings
    System.out.println(Character.getNumericValue('a')); // 10
    System.out.println(Character.getNumericValue('0')); // 0
    System.out.println(Character.getNumericValue('9')); // 9
    System.out.println(Character.getNumericValue('A')); // 10
    System.out.println(Character.getNumericValue('z')); // 35
    System.out.println(Character.getNumericValue('™')); // -1
    System.out.println(123); // 123

    // Random
    System.out.println(new Random().nextInt(16)); // 0-15
  }
}
