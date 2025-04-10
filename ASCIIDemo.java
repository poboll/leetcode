public class ASCIIDemo {
  public static void main(String[] args) {
      // 方法1：直接计算
      int asciiL = 65 + ('L' - 'A');
      System.out.println(asciiL);
      
      // 方法2：字符转换
      char letterL = 'L';
      int asciiValue = (int) letterL;
      System.out.println(asciiValue);
  }
}
