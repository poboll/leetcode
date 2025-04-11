import java.util.Scanner;

// 19718 回文字符串
public class PalindromeString {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int sum = scan.nextInt();
    while(sum -- > 0) {
      String s = scan.next();
      System.out.println(f(s) ? "Yes" : "No");
    } 
    scan.close();
  }

  // 判断字符串是否可以成为回文字符串
  public static boolean f(String s) {
    int l = 0;
    int r = s.length() - 1;
    // 当相等的时候即为中间字符
    while(l < r) {
      char a = s.charAt(l);
      char b = s.charAt(r);
      // 首尾是否相同，相同下一个，不同判断是否为l、q、b；是的话下一个，不是则返回false，不为回文字符串。
      if(a == b) {
        l ++;
        r --;
      }else {
        if(b == 'l' || b == 'q' || b == 'b') {
          r --;
        }else {
          return false;
        }
      }
    }
    return true;
  }
}
