// 1. 基础输入输出
// 题目：读取用户输入的姓名和年龄，然后输出问候语
import java.util.Scanner; // 导入Scanner类用于接收用户输入

/**
 * 基础输入输出示例
 * 功能：接收用户输入的姓名和年龄，输出个性化问候语
 */
public class BasicIO {
    public static void main(String[] args) {
        // 创建Scanner对象，用于读取用户控制台输入
        Scanner scanner = new Scanner(System.in);
        
        // 提示用户输入姓名
        System.out.println("请输入您的姓名：");
        // 读取用户输入的字符串，存储到name变量
        String name = scanner.nextLine();
        
        // 提示用户输入年龄
        System.out.println("请输入您的年龄：");
        // 读取用户输入的整数，存储到age变量
        int age = scanner.nextInt();
        
        // 根据输入信息，输出个性化问候语
        System.out.println("你好，" + name + "！您今年" + age + "岁了。");
        
        // 额外输出，根据年龄进行简单的条件判断
        if (age < 18) {
            System.out.println("您还未成年，请好好学习！");
        } else if (age >= 18 && age < 60) {
            System.out.println("您已成年，请承担责任！");
        } else if( age >=60 && age < 120) {
            System.out.println("您已步入老年，请保重身体！");
        }else {
          System.out.println("输入非法");
        }
        
        // 关闭Scanner对象，释放资源
        scanner.close();
    }
}
