package biweekly_contest._22;

public class FindTheDistanceValueBetweenTwoArrays {
	public static void main(String[] args) {

	}

	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (Math.abs(arr1[i] - arr2[j]) <= d) {
					flag = false;
					break;
				} else {
					flag = true;
				}
			}
			if (flag == true) {
				count++;
			}
		}
		return count;
	}
}
