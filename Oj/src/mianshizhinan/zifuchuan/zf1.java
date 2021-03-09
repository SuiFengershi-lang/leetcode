/*
* 最后一个单词的长度
* */
package mianshizhinan.zifuchuan;

public class zf1 {

    public static void main(String[] args) {
        String s = "hello world ";
        int length = lengthOfLastWord(s);
        System.out.println(length);
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--; // 过滤掉空格
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;   // 找到最后一个单词的头部
        return end - start;
    }
}
