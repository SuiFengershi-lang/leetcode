/*
* 反转字符串中的元音字母
* */
package mianshizhinan.zifuchuan;

public class zf4 {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();     // 转化为字符串数组
        int left = 0, right = s.length() - 1;   // 采用双指针
        while (left < right) {
            while (left < chars.length && judge(chars[left])) left++;   // 找到元音字母
            while (right >= 0 && judge(chars[right])) right--;
            if (left >= right) {
                break;
            }
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    public static boolean judge(char c) {       // 判断一个字符是否是元音字母
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'
                && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }
}
