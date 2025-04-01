public String longestPalindrome(String s) {
  // 三点：长度、起点、终点
  int[] res = new int[3];
  // 每次记录当前坐标 中心点（奇数和偶数）
  for(int i = 0; i < s.length(); ++i) {
    int begin = i;
    int end = i;
    // 奇数回文串：开始中心回文
    while(begin-1>=0 && end+1<s.length() && s.charAt(begin-1) == s.charAt(end+1)) {
      begin--;
      end++;
    }
    // 比已知最长的长度长则记录并更新
    if(end - begin > res[0]) {
      res[0] = end - begin;
      res[1] = begin;
      res[2] = end;
    }
    
    // 偶数回文串：第一次先判断和下一个是否相等，中心回文
    begin = i;
    end = i + 1;
    while (begin>=0 && end<s.length() && s.charAt(begin) == s.charAt(end)) {
      if(end - begin > res[0]) {
        res[0] = end - begin;
        res[1] = begin;
        res[2] = end;
      }
      begin--;
      end++;
    }
  }
  return s.substring(res[1], res[2]+1);
}
