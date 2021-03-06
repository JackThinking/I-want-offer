package nowcoder;

import java.util.Arrays;

/**
 * Created by Citrix on 2019-03-10.
 */
public class Dp {

    /*
    *   coin change
    *   Input: coins = [1, 2, 5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1
    * */

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);//这个条件也忘了
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];//这个条件忘了
    }

    /*
    *   coin change2
    *   Input: coins = [1, 2, 5], amount = 11
        Output: 4
        Explanation: there are four ways to make up the amount:
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1
    * */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    /*
    * 最长上升子序列
    *   Input: [10,9,2,5,3,7,101,18]
        Output: 4
        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    * */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int size = 0;
        int[] temp = new int[n];
        for (int num : nums) {
            int left = 0;
            int right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (num > temp[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            temp[left] = num;
            if (left == size) {
                size++;
            }
        }
        return size;
    }

    /*
    *  最大乘积
    *   Input: [2,3,-2,4]
        Output: 6
        Explanation: [2,3] has the largest product 6.
    * */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxVal = nums[0];
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            maxVal = Math.max(maxVal, max[i]);
        }
        return maxVal;
    }

}
