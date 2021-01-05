package month_challenge._2020_april;

import java.util.*;

/**
 * @author shiyuanchen
 */
public class P6GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		} else {
			Map<String, List<String>> map = new HashMap<>(10);
			for (String s : strs) {
				char[] ca = s.toCharArray();
				Arrays.sort(ca);
				String keyStr = String.valueOf(ca);
				if (!map.containsKey(keyStr)) {
					map.put(keyStr, new ArrayList<>());
				}
				map.get(keyStr).add(s);
			}
			return new ArrayList<>(map.values());
		}
	}

	public static void main(String[] args) {
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(input));
	}
}
