/*
* 反转字符串
* */
package mianshizhinan.zifuchuan;

public class zf2 {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char ch : s) {
            System.out.print(ch + " ");
        }
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1; // 采用双指针
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
