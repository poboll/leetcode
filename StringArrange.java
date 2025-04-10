import java.util.Scanner;
import java.util.HashMap;

public class StringArrange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        scan.close();

        // 长度不同肯定不是排列
        if (s1.length() != s2.length()) {
            System.out.println("NO");
            return;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // 统计s1中字符出现次数
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 检查s2中的字符
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c) || map.get(c) <= 0) {
                System.out.println("NO");
                return;
            }
            map.put(c, map.get(c) - 1);
        }

        System.out.println("YES");
    }
}
