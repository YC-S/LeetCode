package all_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1622_FancySequence {
    final List<List<Op>> ops = new ArrayList<>();
    final List<Long> vals = new ArrayList<>();
    final long mod = 1_000_000_007;

    public void append(int val) {
        vals.add((long) val);
    }

    private Op add(Op left, Op right) {
        return new Op(
                left.index,
                (left.a * right.a) % mod,
                ((left.b * right.a) % mod + right.b) % mod
        );
    }

    private void sparseIndex(Op op) {
        ops.add(new ArrayList<>(Collections.singletonList(op)));

        int i = ops.size() - 1;
        int f = 1;
        while (i - (1 << f) + 1 >= 0) {
            int j = i - (1 << f) + 1;
            ops.get(j).add(add(ops.get(j).get(f - 1), ops.get(j + (1 << (f - 1))).get(f - 1)));
            f += 1;
        }
    }

    public void addAll(int inc) {
        sparseIndex(new Op(vals.size() - 1, 1, inc));
    }

    public void multAll(int m) {
        sparseIndex(new Op(vals.size() - 1, m, 0L));
    }

    public int getIndex(int idx) {
        if (idx >= vals.size())
            return -1;

        int lo = 0, hi = ops.size() - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (ops.get(m).get(0).index < idx) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }

        Op cur = new Op(0, 1, 0);

        for (int i = lo; i < ops.size(); ) {
            int f = ops.get(i).size() - 1;
            cur = add(cur, ops.get(i).get(f));
            i += (1 << f);
        }

        return (int) (((vals.get(idx) * cur.a) % mod + cur.b) % mod);
    }

    static class Op {
        int index;
        long a;
        long b;

        Op(int index, long a, long b) {
            this.index = index;
            this.a = a;
            this.b = b;
        }
    }
}
