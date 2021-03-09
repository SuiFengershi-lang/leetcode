/*
* 翻转字符串里的单词
* */
package mianshizhinan.zifuchuan;

public class zf6 {

    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        String ans = reverseWords(s);
        System.out.println(ans);
    }

    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");    // 分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {   // 碰见空字符串直接跳过
                continue;
            }
            res.append(strings[i] + " ");
        }
        return res.toString().trim();
    }
}
