package Calc;

public class Calculator {

	private int num1 ; 
	private int num2 ; 
	private char cal_ch; //연산자
	
	static private int cnt = 0 ; 
	
	public void cnt_inc() {
		++cnt;  
		if(cnt>=4) {
			cnt %=3; 
		}
	}
	
	public int getCnt() {
		return cnt;
	}
	
	public void setValues(String str) { 
		
		if(str.charAt(str.length()-1) == '\n') //마지막이 개행문자라면 
			str = str.substring(0, str.length()-1); //개행문자를 지워준다.

		switch(cnt) {
			case 1 : setNum1(str); break;
			case 2 : setCal_ch(str);break;
			case 3 : setNum2(str);break;
			default : cnt = 0 ; 
		}
	}
	
	
	public String calculate() {
		String answer =num1+" "+cal_ch+" "+num2+" = "; 
		
		switch(cal_ch) {
		case '+' : answer+=(num1+num2); break;
		case '-' : answer+=(num1-num2); break;
		case '*' : answer+=(num1*num2); break;
		case '/' : answer+=((double)num1/num2); break;
		default : //error 
			answer = "error" ; 
		}
		return answer ; 
	}
	
	public void setNum1(String str) {
		try {
			num1 = Integer.parseInt(str);
		}catch(NumberFormatException e) { //Integer.parseInt()가 실패할 경우.
			System.err.println("숫자를 입력해주세요.");
		}
	}
	
	public void setNum2(String str) {
		try {
			num2 = Integer.parseInt(str); 
		}catch(NumberFormatException e) {
			System.err.println("숫자를 입력해주세요.");
		}
		
	}
	
	public void setCal_ch(String str) {
		if(str.length() > 1) { cal_ch = '?';} //
		else { cal_ch = str.charAt(0); }
	}
}
