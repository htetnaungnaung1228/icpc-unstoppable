import java.util.Stack;

public class InfixToPostFix {
	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	static String inToPost(String exp) {
		String result = new String("");
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c))
				result += c;

			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					stack.pop();
			}
			else {
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
					result += stack.pop();
				stack.push(c);
			}
		}

		while (!stack.isEmpty())
			result += stack.pop();

		return result;
	}

	public static void main(String[] args) {
		String exp = "1+2*3/4";
		String exp1="(84-2)/54+72-9*100";
		System.out.println(inToPost(exp));
		System.out.println(inToPost(exp1));
	}

}
