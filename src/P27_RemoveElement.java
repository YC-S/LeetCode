import java.util.ArrayList;
import java.util.List;

public class P27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                res.add(nums[i]);
            }
        }
        for (int i = 0; i < res.size(); ++i) {
            nums[i] = res.get(i);
        }
        return res.size();
    }
}
