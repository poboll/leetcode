import java.util.Scanner;

// 2647 回文日期
public class PalindromeDate {
    // 用于标记是否找到两种回文日期
    static boolean found1 = false; // 普通回文日期
    static boolean found2 = false; // ABABBABA型回文日期
    
    // 存储每个月的天数
    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};// 1、3、5、7、8、10、12是31天
    
    /**
     * 判断是否为闰年
     * @param year 年份
     * @return 是闰年返回1，否则返回0
     */
    static int isLeap(int year) {
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return 1;
        }
        return 0;
    }
    
    /**
     * 获取指定年月的天数
     * @param year 年份
     * @param month 月份
     * @return 该月的天数
     */
    static int getDay(int year, int month) {
        if(month == 2) {
            return 28 + isLeap(year);
        }
        return months[month];
    }
    
    /**
     * 日期增加一天
     * @param date 包含年月日的数组
     */
    static void nextDay(int[] date) {
        int year = date[0];
        int month = date[1];
        int day = date[2];
        
        day++;
        if(day > getDay(year, month)) {
            day = 1;
            month++;
            if(month > 12) {
                month = 1;
                year++;
            }
        }
        
        date[0] = year;
        date[1] = month;
        date[2] = day;
    }
    
    /**
     * 判断日期是否为回文日期
     * @param dateStr 日期字符串
     * @return 是回文日期返回true，否则返回false
     */
    static boolean check1(String dateStr) {
        for(int i = 0, j = 7; i < j; i++, j--) {
            if(dateStr.charAt(i) != dateStr.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 判断是否为ABABBABA型回文日期
     * @param dateStr 日期字符串
     * @return 是ABABBABA型返回true，否则返回false
     */
    static boolean check2(String dateStr) {
        char a = dateStr.charAt(0);
        char b = dateStr.charAt(1);
        char c = dateStr.charAt(2);
        char d = dateStr.charAt(3);
        
        return a == c && b == d && a != b;
    }
    
    /**
     * 主方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取输入的日期
        String input = scanner.nextLine();
        
        int year = Integer.parseInt(input.substring(0, 4));
        int month = Integer.parseInt(input.substring(4, 6));
        int day = Integer.parseInt(input.substring(6, 8));
        
        // 存储年、月、日的数组
        int[] date = {year, month, day};
        
        // 寻找下一个回文日期和ABABBABA型回文日期
        while(!found1 || !found2) {
            nextDay(date);
            
            // 格式化日期为8位字符串
            String dateStr = String.format("%04d%02d%02d", date[0], date[1], date[2]);
            
            // 检查是否为回文日期
            if(check1(dateStr)) {
                if(!found1) {
                    found1 = true;
                    System.out.println(dateStr);
                }
                
                // 检查是否为ABABBABA型回文日期
                if(!found2 && check2(dateStr)) {
                    found2 = true;
                    System.out.println(dateStr);
                }
            }
        }
        
        scanner.close();
    }
}
