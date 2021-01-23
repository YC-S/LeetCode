package all_problems;

import java.util.*;

public class P1233_RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparing(s -> s.length()));
        Set<String> seen = new HashSet<>();
        outer:
        for (String f : folder) {
            for (int i = 2; i < f.length(); ++i)
                if (f.charAt(i) == '/' && seen.contains(f.substring(0, i)))
                    continue outer;
            seen.add(f);
        }
        return new ArrayList<>(seen);
    }
}
