import java.util.Arrays;
import java.util.HashMap;

/**
 *
 */
public class Test5 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
            System.out.println(Arrays.toString(getIndex(nums, target)));
    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，
     * 并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] getIndex(int[] nums, int target) {
        var hash = new HashMap<Integer, Integer>();
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                answer[0] = i;
                answer[1] = hash.get(target - nums[i]);
                return answer;
            }
            hash.put(nums[i],i);
        }
        return null;
    }
}
