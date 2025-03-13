// 14.最长公共前缀
// https://leetcode.cn/problems/longest-common-prefix/solutions/2256929/java-jie-zhu-indexofsubstringisempty-ji-2maer/
public class LongestCommonPrefix {

    // 定义查找字符串数组中最长公共前缀的方法
    public String longestCommonPrefix(String[] strs) {
        // 1. 判断输入是否为空或长度为0
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 2. 以第一个字符串为“参考”，从左到右逐字符比较
        for (int i = 0; i < strs[0].length(); ++i) {
            // 2.1 获取第一个字符串在索引 i 处的字符
            char c = strs[0].charAt(i);

            // 2.2 将该字符与剩余字符串在同一索引位置的字符进行对比
            for (int j = 1; j < strs.length; ++j) {
                // 判断两个条件：
                // (a) 是否已经超出当前字符串的长度
                // (b) 当前字符是否与第一个字符串的字符不匹配
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    // 一旦发现不匹配或越界，就返回第一个字符串
                    // 从索引 0 到 i（不含 i）的子串，作为公共前缀
                    return strs[0].substring(0, i);
                }
            }
        }
        // 3. 如果遍历完第一个字符串都没出现不匹配，
        // 说明第一个字符串就是最长公共前缀
        return strs[0];
    }

    // 主函数，测试代码
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        // 示例1
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println("示例1结果：" + solution.longestCommonPrefix(strs1)); // 预期输出 "fl"

        // 示例2
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("示例2结果：" + solution.longestCommonPrefix(strs2)); // 预期输出 ""
    }
}
