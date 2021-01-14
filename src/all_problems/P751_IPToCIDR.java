package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P751_IPToCIDR {
    public List<String> ipToCIDR(String ip, int n) {
        long num = ipToLong(ip);
        List<String> res = new ArrayList<>();
        while (n > 0) {
            int suffixLen = Math.min(bitLen(num & (-num)), bitLen(n)) - 1;
            int maskLen = 32 - suffixLen;
            res.add(longToIp(num) + "/" + maskLen);
            num += 1 << suffixLen;
            n -= 1 << suffixLen;
        }
        return res;
    }

    private String longToIp(long num) {
        return (num >> 24) + "." + (num >> 16) % 256 + "." + (num >> 8) % 256 + "." + num % 256;
    }

    private int bitLen(long num) {
        if (num == 0) {
            return 1;
        }
        int cnt = 0;
        while (num != 0) {
            ++cnt;
            num >>= 1;
        }
        return cnt;
    }

    private long ipToLong(String ip) {
        String[] paths = ip.split("\\.");
        long res = 0;
        for (String path : paths) {
            res = (res << 8) + Long.parseLong(path);
        }
        return res;
    }
}
