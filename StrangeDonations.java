public class StrangeDonations {
  public static void main(String[] args) {
    int totalAmount = 1000000;  // 总金额 100 万元
    int maxParts = 0;  // 最多可以分的份数

    // 计算7的各个次方
    int[] powersOf7 = new int[8];
    powersOf7[0] = 1;  // 7^0 = 1
    for (int i = 1; i < powersOf7.length; i++) {
        powersOf7[i] = powersOf7[i - 1] * 7;
    }

    // 从大到小尝试每个7的次方数
    for (int i = powersOf7.length - 1; i >= 0; i--) {
        int currentAmount = powersOf7[i];
        // 当前金额可以最多分5份
        int count = totalAmount / currentAmount;
        if (count > 5) {
            count = 5;  // 每种金额最多分5份
        }
        maxParts += count;
        totalAmount -= count * currentAmount;
        if (totalAmount == 0) {
            break;  // 如果已经分完，就停止
        }
    }

    System.out.println(maxParts);
  }
}
