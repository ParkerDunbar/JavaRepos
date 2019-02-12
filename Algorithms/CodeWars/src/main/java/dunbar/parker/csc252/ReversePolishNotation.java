package dunbar.parker.csc252;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		System.out.println(evaluate("5 1 2 + 4 * + 3 -"));
	}

	public static double evaluate(String expr) {
		Stack<String> stack = new Stack<String>();
		String[] split = expr.split(" ");
		for(int i = split.length - 1; i >= 0; i--) {
			stack.push(split[i]);
		}

		return 0;
	}

}
