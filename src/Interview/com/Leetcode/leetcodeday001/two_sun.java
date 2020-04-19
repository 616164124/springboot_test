package Leetcode.leetcodeday001;


import java.util.HashMap;
import java.util.Map;

/*      第一题
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
        示例:
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]

  */
//两数之和
public class two_sun {
    //方法一  缺点
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { // i 为找到第一个元素
            for (int j = i + 1; j < nums.length; j++) {// j 为找到第二个元素
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 利用hashmap
     * 遍历数组将每个数组中的元素与在数组中的索引,全部放入map中,在map中寻找complement的值相等的 k 值 <k,value>
     * <p>
     * map 的k 值为数组中的元素
     *
     * @param nums
     * @param target
     * @return
     */
    //方法二
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  //complement 为差值
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}

class twosum {
    public static void main(String[] args) throws Exception {
        int[] i = {1, 2, 4, 5, 7, 3};
        two_sun two_sun = new two_sun();
        int[] ints = two_sun.twoSum(i, 8);
        for (int j = 0; j < ints.length; j++) {
            System.out.println(ints[j]);
        }
        /************************************************/
        int[] ints2 = two_sun.twoSum2(i, 8);
        for (int j = 0; j < ints2.length; j++) {
            System.out.println(ints2[j]);
        }

    }
}
