package com.example.java_module.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayInterview {


    /**
     * 二分法，查找value
     */
    public int binarySearch(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (value == arr[mid]) {
                return arr[mid];
            }
            if (value > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 将0移动到末尾
     * {2,0,4,0,5} -> {2,4,5,0,0}
     */
    public int[] moveZeros(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != k) {
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
                k++;
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    /**
     * 删除排序数组中相同的元素,返回移除后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 删除指定元素 返回移除后数组的新长度
     * {1,3,4,3,2,3,9} 删除 3
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    /**
     * 三路快排
     * 数组只有 0，1，2，变成有序
     * {1,2,0,1,2,0} -> {0,0,1,1,2,2}
     */
    public int[] sortNum(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            } else if (nums[i] == 0) {
                zero++;
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        return nums;
    }

    /**
     * 有序数组寻找两个元素和为 target
     * {1,3,4,8} 和 5
     * 对撞指针
     */
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[2];

        while (l < r) {
            if (nums[l] + nums[r] == target) {
                result[0] = l;
                result[1] = r;
                return result;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }

    /**
     * 无序数组寻找两个元素和为 target
     * {1,3,4,8} 和 5
     * 对撞指针
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 给定一个数组和一个数字，找到数组中最短的连续子数组的长度 大于 此数字
     * {1,5,2,3,7,4}  10 则返回 2(7 + 4)
     * <p>
     * 思路： 滑动窗口
     */
    public int minSubArrayLen(int[] arr, int s) {
        int l = 0, r = -1;
        int sum = 0;
        int res = arr.length + 1;

        while (l < arr.length) {
            if (r + 1 < arr.length && sum < s) {
                r++;
                sum += arr[r];
            } else {
                sum -= arr[l];
                l++;
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == arr.length + 1) {
            return 0;
        }
        return res;
    }

    /**
     * 一个字符串中没有重复的最长子串
     * "abcabcbb" ->  3
     * 如果 s[j] 在 [i, j)范围内有与 j'重复的字符，我们不需要逐渐增加 i
     * 我们可以直接跳过 [i，j'] 范围内的所有元素，并将 i 变为 j' + 1
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    /**
     * 电话号码 23，
     * 2，abc
     * 3,def
     * ab,ae,af...所有组合
     */
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();
        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

        return;
    }


    /**
     * 斐波那契数列的定义是 f(n + 1) = f(n) + f(n - 1)f(n+1)=f(n)+f(n−1)
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib2(n - 2);
    }

    /**
     * 斐波那契数列的定义是 f(n + 1) = f(n) + f(n - 1)f(n+1)=f(n)+f(n−1)
     */
    public int fib2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 斐波那契数列的定义是 f(n + 1) = f(n) + f(n - 1)f(n+1)=f(n)+f(n−1)
     * 动态规划
     */
    public int fib3(int n) {
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 给定一个正整数，分割成多个数字的和，若要数字乘机最大，求分割方法，返回最大乘积
     * 动态规划
     */
    public int getMax(int n) {

        int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // j + (i -j)
                arr[i] = max2(arr[i], j * (i - j), j * arr[i - j]);
            }
        }
        return arr[n];
    }

    public int max2(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2:
     * <p>
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     * <p>
     * 不能取连续的两个最大值
     * 动态转移方程
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    /**
     * 0 - 1 背包问题
     * 有n件物品和容量为m的背包 给出i件物品的重量以及价值 求解让装入背包的物品重量不超过背包容量 且价值最大
     *
     * W 表示最大容量
     * int[] w 表示容量的数组
     * int[] v 价值
     */
    public int bag(int W, int[] w, int[] v) {
        int n = w.length;
        if (n == 0 || W == 0){
            return 0;
        }

        int[] f = new int[W + 1];
        for (int j = 0; j <= W; j++){
            f[j] = (j >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++)
            for (int j = W; j >= w[i]; j--)
                f[j] = Math.max(f[j], f[j - w[i]] + v[i]);
        return f[W]; // 最优解
    }

    /**
     * 最长上升子序列
     * {3,1,4,6,7,2,10} -> {3,4,6,7,10} 长度为4
     */
    public int lengthOfLIS(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] < nums[i]){
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++){
            res = Math.max(res, memo[i]);
        }
        return res;
    }


}
