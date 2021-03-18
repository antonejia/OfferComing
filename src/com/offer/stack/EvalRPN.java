package com.offer.stack;
/**
后缀表达式的值
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
import java.util.Stack;

/*我的版本：
 * public class EvalRPN {

	public static int evalRPN(String[] tokens){
		if (tokens == null || tokens.length == 0){
			return -1;
		}
		Stack<Integer> q = new Stack<Integer>();
		for (int i = 0; i < tokens.length; ++i){
			if (!isOperator(tokens[i])){
				q.push(Integer.valueOf(tokens[i]));
			}else {
				int operand1 = q.pop();
				int operand2 = q.pop();
				int result = calc(operand1, operand2, tokens[i]);
				q.push(result);
			}
		}
		
		return q.peek();
	}
	public static boolean isOperator(String s){
		if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
			return true;
		}
		return false;
	}
	public static int calc(int operand1, int operand2, String operator){
		if ("+".equals(operator)){
			return operand1 + operand2;
		}else if ("-".equals(operator)){
			return operand2 - operand1;
		}else if ("*".equals(operator)){
			return operand1 * operand2;
		}else {
			return operand2 / operand1;
		}
	}
	
	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));

	}
}*/
//参考版本
public class EvalRPN {

	public static int evalRPN(String[] tokens){
		if (tokens == null || tokens.length == 0){
			return -1;
		}
		Stack<Integer> q = new Stack<Integer>();
		String operators = "+-*/";
		for (String token : tokens){
			if (!operators.contains(token)){
				q.push(Integer.valueOf(token));
			}else {
				int operand1 = q.pop();
				int operand2 = q.pop();
				int result = 0;
				int index = operators.indexOf(token);
				switch(index){
					case 0:
						result = operand2 + operand1;
						break;
					case 1:
						result = operand2 - operand1;
						break;
					case 2:
						result = operand2 * operand1;
						break;
					case 3:
						result = operand2 / operand1;
						break;
				}
				q.push(result);
			}
		}
		
		return q.peek();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));

	}
}
