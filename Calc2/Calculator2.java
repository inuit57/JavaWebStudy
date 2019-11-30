package Calc2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* 
 * 한줄로 들어온 수식을 처리한다. 
 * 중위 수식을 후위 수식으로 바꿔서 처리한다. 
 * 
 * 괄호도 입력을 받을 수 있도록 구현하는 것이 목표. 
 */
public class Calculator2 {
	
	private Stack<Character> op_stk = new Stack<Character>(); 
	private ArrayList<String> arr = new ArrayList<String>(); 
	
	private void clearMem() {
		op_stk.clear();
		arr.clear();
	}
	
	
	//중위-> 후위로 변환 
	//
	public boolean op_check(char op) {
		if(op == '(') return true; 
		
		if(!op_stk.isEmpty()) {	
			switch(op) {
			case '+' :
			case '-' : 
				if(op_stk.peek() =='(') return true; 
				return false ; 
			case '*' :
			case '/' :
				if(op_stk.peek()=='*' || op_stk.peek()== '/') return false; 
				return true;
			default : 
				return false;
			}
		}
		return true;
	}
	
	
	//for test.
	public void printArr() {
		Iterator<String> it = arr.iterator(); 
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	public void getInput(String str) {
		if(str.charAt(str.length()-1) == '\n') //마지막이 개행문자라면 
			str = str.substring(0, str.length()-1); //개행문자를 지워준다.
		
		char[] chArr = str.toCharArray(); 
		String num = "" ; 
		
		for(int i=0 ; i< chArr.length ; ++i) {
			if(Character.isDigit(chArr[i])){
				num+=chArr[i] ; //숫자라면 뒤에 계속 붙여준다.  
			}
			else {//연산자를 만난 경우.
				if(!num.equals("")) {
					arr.add(num);  //만들어진 숫자를 넣어준다. 
					num="" ; //다른 숫자를 받기위해서 다시 초기화. 
				} 
				
				if(op_stk.isEmpty()) { //스택이 비어있다면 넣어준다.
					op_stk.add(chArr[i]) ; 
				}
				else {
					if(chArr[i] == ')') {
						while(op_stk.peek() != '(') {
							arr.add(""+op_stk.pop());
						}
						op_stk.pop(); // '(' 제거
					}
					else {	
						while(!op_check(chArr[i])) {
							arr.add(""+op_stk.pop()); 
						}
						op_stk.add(chArr[i]); 
					}
				}
			}
		}	
		// A+B처럼 뒤에 연산자가 더 안오는 경우. 끝처리 해주기. 
		if(!num.equals("")) {
			arr.add(num); 
			num = "" ; 
		}
		//스택에 남은 값들 빼서 넣어주기 
		while(!op_stk.isEmpty()) {
			arr.add(""+op_stk.pop()) ;
		}
	}
	
	//연산자인지 확인하는 함수 
	public boolean isOp(String str) {
		String[] op_str = {"+","-","*","/"};
		for(int i=0 ; i<4; ++i) {
			if( str.equals(op_str[i])) return true; 
		}
		return false; 
	}
	
	
	//사칙연산을 수행하고 연산 결과값을 String형태로 반환.
	public String calcurate(String num1, String num2, String op) {
		String answer = ""; 
		double[] Dnum = new double[2];
		
		Dnum[0] = Double.parseDouble(num1); 
		Dnum[1] = Double.parseDouble(num2); 
		
		switch(op) {
		case "+" : 
			answer = Double.toString(Dnum[0]+Dnum[1]); 
			break;
		case "-" :
			answer = Double.toString(Dnum[0]-Dnum[1]); 
			break; 
		case "*" : 
			answer = Double.toString(Dnum[0]*Dnum[1]); 
			break;
		case "/" :
			answer = Double.toString(Dnum[0]/Dnum[1]); 
			break;
		default : 
			answer = "error" ; 
		}
		
		return answer ; 
	}
	
	
	
	public String doCalculate() {
		
		String answer = "" ; 
		
		Iterator<String> it = arr.iterator(); 
		Stack<String> stk = new Stack<String>(); 
		
		while(it.hasNext()) {
			String tmp = it.next(); 
		
			if(!isOp(tmp)) {
				stk.add(tmp); 
			}
			else {
				String num1, num2; 
				num2 = stk.pop(); 
				num1 = stk.pop(); 
				stk.add(calcurate(num1, num2 , tmp));
			}
		}
		answer = stk.pop(); 
		
		if(!stk.isEmpty()) answer = "error" ; 
		
		//초기화를 시켜버린다. 
		clearMem(); 
		
		return answer ; 
	}
	
}
