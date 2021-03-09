/*
* 至少有k个重复字符的最长字串
* */
package mianshizhinan.recursion;

public class rs1 {

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        int res = longestSubstring(s, k);
        System.out.println(res);
    }

    public static int longestSubstring(String s, int k) {
        int length = s.length();
        return count(s.toCharArray(), k, 0, length - 1);
    }

    public static int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k) {  // 字符串长度小于k
            return 0;
        }
        int[] times = new int[26];  // 字符出现的次数
        for (int i = p1; i <= p2; i++) {
            times[chars[i] - 'a']++;
        }
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k) {    // 过滤掉不满足题意的字符
            p1++;
        }
        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k) {
            p2--;
        }
        if (p2 - p1 + 1 < k) {
            return 0;
        }
        for (int i = p1; i <= p2; i++) {
            if (times[chars[i] - 'a'] < k) {    // 将字符串分成两部分递归求解
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }
}
