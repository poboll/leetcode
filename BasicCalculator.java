// 2. 基础加减乘除计算器
// 题目：编写一个简单计算器，可以进行两个数的加减乘除运算

import java.util.Scanner;

/**
 * 基础计算器程序
 * 功能：接收用户输入的两个数和运算符，执行相应的加减乘除运算
 */
public class BasicCalculator {
    public static void main(String[] args) {
        // 创建Scanner对象用于接收用户输入
        Scanner scanner = new Scanner(System.in);
        
        // 提示用户输入第一个数
        System.out.println("请输入第一个数：");
        double num1 = scanner.nextDouble();
        
        // 提示用户输入运算符
        System.out.println("请输入运算符（+、-、*、/）：");
        // 读取下一个字符作为运算符
        char operator = scanner.next().charAt(0);
        
        // 提示用户输入第二个数
        System.out.println("请输入第二个数：");
        double num2 = scanner.nextDouble();
        
        // 定义变量存储计算结果
        double result = 0.0;
        
        // 根据运算符进行相应的运算
        switch (operator) {
            case '+': // 加法运算
                result = num1 + num2;
                break;
            case '-': // 减法运算
                result = num1 - num2;
                break;
            case '*': // 乘法运算
                result = num1 * num2;
                break;
            case '/': // 除法运算
                // 判断除数是否为0，避免除以0的错误
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("错误：除数不能为0！");
                    // 关闭Scanner并结束程序
                    scanner.close();
                    return; // 提前结束程序
                }
                break;
            default: // 处理无效运算符
                System.out.println("错误：无效的运算符！");
                scanner.close();
                return; // 提前结束程序
        }
        
        // 输出计算结果
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        
        // 关闭Scanner对象
        scanner.close();
    }
}
