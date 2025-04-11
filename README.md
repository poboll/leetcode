# 蓝桥杯Java-力扣刷题
> 零基础qwq坚持每日一题

## 题目列表

- **3月13日** [14.最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/)
- **3月28日** [5.最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)
- **4月1日**
  - [基础输入输出](./BasicIO.java)
  - [基础加减乘除计算器](./BasicCalculator.java)
- **4月9日** [奇怪的捐赠 - 蓝桥云课](./StrangeDonations.java)
- **4月10日**
  - [确定字符串是否是另一个的排列](./StringArrange.java)
  - [ASCII演示](./ASCIIDemo.java)
- **4月11日**
  - [19709.好数 - 蓝桥云课](./GoodNumbers.java)
  - [19718.回文字符串 - 蓝桥云课](./PalindromeString.java)
  - [2647.回文日期 - Acwing](./PalindromeDate.java)
  - [97.k倍区间 - 蓝桥云课](./KRange.java)

## 算法笔记

### 日期处理
- **闰年判断**：非整百能被4整除、整百能被400整除
- **星期几速算**：Excel=WEEKDAY("2025-04-11", 2)

### 数论
- **素数**：大于1且只能被1和自身整除的正整数（2是最小素数）
- **最大公约数(GCD)**：辗转相除法
```java
int gcd(int a, int b) {
  while (b != 0) {
    int temp = b;
    b = a % b;
    a = temp;
  }
  return a;
}
```
- **最小公倍数(LCM)**
```java
int lcm(int a, int b) {
  return (a * b) / gcd(a, b);
}
```

### 数位拆解
统计1到2025数字序列中0出现的次数，答案528次
```java
int n = 2025, amount = 0;
for(int i = 1; i <= n; i++) {
  int a = i;
  while(a > 0) {
    if(a % 10 == 0) {
      amount++;
    }
    a /= 10;
  }
}
```

### 搜索算法
- **DFS**（深度优先搜索）
  - 起点为左上角(0,0)，终点为右下角(n-1,m-1)
  - 上下左右四个方向移动：`int[] dx = {-1, 1, 0, 0}; int[] dy = {0, 0, -1, 1};`
```java
public class MazeSolver {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 上下左右方向
    static int[] dy = {0, 0, -1, 1};
    
    public static boolean dfs(int x, int y, int n, int m) {
        if(x == n-1 && y == m-1) return true; // 到达终点
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maze[nx][ny] == 0) {
                visited[nx][ny] = true;
                if(dfs(nx, ny, n, m)) return true;
            }
        }
        return false;
    }
}
```

- **BFS**（广度优先搜索）
  - 逐层探索相邻节点
  - 无权图中保证最短路径