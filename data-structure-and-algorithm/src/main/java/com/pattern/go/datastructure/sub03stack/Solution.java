package com.pattern.go.datastructure.sub03stack;

import java.util.Stack;

public class Solution {

  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char atChar = s.charAt(i);
      if (atChar == '(' || atChar == '[' || atChar == '{') {
        stack.push(atChar);
      } else if (atChar == ')' || atChar == ']' || atChar == '}') {
        if (stack.isEmpty()) {
          return false;
        }

        char topChar = stack.pop();

        if (atChar == ')' && topChar != '(') {
          return false;
        } else if (atChar == ']' && topChar != '[') {
          return false;
        } else if (atChar == '}' && topChar != '{') {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {

    System.out.println((new Solution()).isValid("()[]{}"));
    System.out.println((new Solution()).isValid("([)]"));
  }
}
