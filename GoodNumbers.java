import java.util.Scanner;

// 19709 好数
public class GoodNumbers {
    public static int good(int a) {
      int x = 1;// 当前位
      while(a != 0) {
        int t = a % 10;// 去除当前位上的数字
        if(x % 2 == 1) {
          if(t % 2 == 0) {
            return 0;
          }
        }else {
          if(t % 2 == 1) {
            return 0;
          }
        }
        a = a / 10;
        x++;
      }
      return 1;  // 移到循环外部
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        scan.close();
        int count = 0;
        for(int i = 1; i <= a; ++i) {  // 从1开始
          if(good(i) == 1){
            count++;
          }
        }
        System.out.println(count);
    }
}
