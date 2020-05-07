package april_challenge;

/**
 * @author shiyuanchen
 */
public class P9BackspaceStringCompare {
	public static boolean backspaceCompare(String S, String T) {
		String s = helper(S);
		String t = helper(T);
		return s.equals(t);
	}

	public static String helper(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < s.length()) {
			if (s.charAt(i) == '#') {
				if (sb.length() == 0) {
					i++;
					continue;
				} else {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				sb.append(s.charAt(i));
			}
			i++;
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		String s1 = "a##c";
		String t1 = "#a#c";
		System.out.println(backspaceCompare(s1, t1));
	}
}
