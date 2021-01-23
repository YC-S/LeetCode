package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1166_DesignFileSystem {
    Map<String, Integer> file = new HashMap<>();

    public P1166_DesignFileSystem() {
        file.put("", -1);
    }

    public boolean createPath(String path, int value) {
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!file.containsKey(parent)) {
            return false;
        }
        return file.putIfAbsent(path, value) == null;
    }

    public int get(String path) {
        return file.getOrDefault(path, -1);
    }
}
