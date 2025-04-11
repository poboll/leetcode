import java.util.Scanner;

// 97 k 倍区间
public class KRange {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    long[] b = new long[200000];
    long sum = 0;
    long count = 0;
    for(int i = 0; i < n; ++ i) {
      a[i] = sc.nextInt();
      sum +=a[i];
      // 求余数将相同的元素放到一起
      b[(int)(sum % k)] ++;
    }
    sc.close();
    // 余数为0的元素自成一个 k 倍空间
    count = count + b[0];
    for(int i = 0; i < k; ++ i) {
      //两个相同玉树的元素他们的差一定为 k 倍区间， 13%2=1 25%2=1  （25-13）%2==0
      // 任意两个数都可以组合一次，相当于 c (2, x) = x (x - 1) / 2
      count +=(b[i]*(b[i]-1)/2);
    }
    System.out.println(count);
  }
}
