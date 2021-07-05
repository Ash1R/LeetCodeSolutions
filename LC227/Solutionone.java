//https://leetcode.com/problems/basic-calculator-ii/
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int curop = 0;
        int cur = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (Character.isDigit(chars[i])){
                cur = cur * 10 + Character.getNumericValue((chars[i]));
                
            } if (!Character.isDigit(chars[i]) && !Character.isWhitespace(chars[i]) || i == chars.length - 1) {
                if (curop == 1){
                    stack.push(-cur);
                } else if (curop == 0){
                    stack.push(cur);
                } else if (curop == 2){
                    int temp = stack.pop();
                    stack.push(temp * cur);
                } else if (curop == 3){
                    int temp = stack.pop();
                    stack.push(temp / cur);
                }
                if (chars[i] == '+'){
                    curop = 0;
                } else if (chars[i] == '-'){
                    curop = 1;
                } else if (chars[i] == '*'){
                    curop = 2;
                } else if (chars[i] == '/'){
                    curop = 3;
                }
                cur = 0;
            }
                
        }
        int ans = 0;
        while (stack.isEmpty() == false){
            ans += stack.pop();
        }
        return ans;
    }
}
