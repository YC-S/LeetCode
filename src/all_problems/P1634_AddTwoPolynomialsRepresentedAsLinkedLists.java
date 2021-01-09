package all_problems;

public class P1634_AddTwoPolynomialsRepresentedAsLinkedLists {
    public PolyNode addPloy(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode();
        PolyNode curr = dummy;
        while (poly1 != null || poly2 != null) {
            int e1 = poly1 == null ? -1 : poly1.power;
            int e2 = poly2 == null ? -1 : poly2.power;
            if (e1 > e2) {
                curr.next = new PolyNode(poly1.coefficient, poly1.power);
                poly1 = poly1.next;
                curr = curr.next;
            } else if (e1 < e2) {
                curr.next = new PolyNode(poly2.coefficient, poly2.power);
                poly2 = poly2.next;
                curr = curr.next;
            } else {
                if (poly1.coefficient + poly2.coefficient != 0) {
                    curr.next = new PolyNode(poly1.coefficient + poly2.coefficient, poly1.power);
                    curr = curr.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }
        return dummy.next;
    }

    static class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        public PolyNode() {
        }

        public PolyNode(int coefficient, int power) {
            this.coefficient = coefficient;
            this.power = power;
        }

        public PolyNode(int coefficient, int power, PolyNode next) {
            this.coefficient = coefficient;
            this.power = power;
            this.next = next;
        }
    }
}
