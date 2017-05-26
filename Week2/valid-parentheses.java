public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c =='(' || c=='{' || c=='[') stack.push(c);
            else if(stack.isEmpty()||Math.abs(c-stack.pop())>2) return false;
        }
        return stack.isEmpty();
    }
}
