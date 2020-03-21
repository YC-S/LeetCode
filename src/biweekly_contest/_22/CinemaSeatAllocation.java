package biweekly_contest._22;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CinemaSeatAllocation {
	public static void main(String[] args) {
		int[][] reservedSeats = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
		int[][] reservedSeats2 = {{2, 1}, {1, 8}, {2, 6}};
		int[][] reservedSeats3 = {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
		CinemaSeatAllocation solution = new CinemaSeatAllocation();
		System.out.println(solution.maxNumberOfFamilies(3, reservedSeats));
		System.out.println(solution.maxNumberOfFamilies(2, reservedSeats2));
		System.out.println(solution.maxNumberOfFamilies(4, reservedSeats3));
	}

	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int[][] matrix = new int[n][10];
		Set<Pair> set = new HashSet<>();
		for (int[] reservedSeat : reservedSeats) {
			set.add(new Pair(reservedSeat[0], reservedSeat[1]));
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!set.contains(new Pair(i, 7))
				&& !set.contains(new Pair(i, 4))
				&& !set.contains(new Pair(i, 5))
				&& !set.contains(new Pair(i, 6))) {
				if (!set.contains(new Pair(i, 2))
					&& !set.contains(new Pair(i, 3))
					&& !set.contains(new Pair(i, 8))
					&& !set.contains(new Pair(i, 9))) {
					count += 2;
				} else {
					count++;
				}
			} else if (!set.contains(new Pair(i, 2))
				&& !set.contains(new Pair(i, 3))
				&& !set.contains(new Pair(i, 4))
				&& !set.contains(new Pair(i, 5))) {
				count++;
			} else if (!set.contains(new Pair(i, 6))
				&& !set.contains(new Pair(i, 7))
				&& !set.contains(new Pair(i, 8))
				&& !set.contains(new Pair(i, 9))) {
				count++;
			}
			set.remove(new Pair(i, 1));
			set.remove(new Pair(i, 2));
			set.remove(new Pair(i, 3));
			set.remove(new Pair(i, 4));
			set.remove(new Pair(i, 5));
			set.remove(new Pair(i, 6));
			set.remove(new Pair(i, 7));
			set.remove(new Pair(i, 8));
			set.remove(new Pair(i, 9));
			set.remove(new Pair(i, 10));
		}
		return count;
	}
}

class Pair {
	public int x;
	public int y;

	public Pair() {
		this.x = x;
		this.y = y;
	}

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pair)) return false;
		Pair pair = (Pair) o;
		return x == pair.x &&
			y == pair.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
