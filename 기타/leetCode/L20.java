package leetCode;

import java.util.Stack;

public class L20 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		if (s.length() == 0 || s.length() % 2 != 0)
			return false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				switch (c) {
				case ')':
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else
						stack.push(')');
					break;
				case '}':
					if (!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					} else
						stack.push('}');
					break;
				case ']':
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else
						stack.push(']');
				}
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		} else
			return false;
	}
}
