/*
* 字符串中的第一个唯一字符
* */
package mianshizhinan.zifuchuan;

import java.util.HashMap;
import java.util.Map;

public class zf3 {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(firstUniqChar2(s));
    }

    public static int firstUniqChar1(String s) {
        Map<Character,Integer> map = new HashMap<>();   // 用map存放单词中每个字母出现的次数
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        int[] nums = new int[26];   // 存放每个字符出现的次数
        char[] chars = s.toCharArray(); // 将字符串转化为字符数组
        for (char ch : chars) {
            nums[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
