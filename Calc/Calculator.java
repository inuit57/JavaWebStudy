package Calc;

public class Calculator {

	static int num1 ; //값을 기억하도록 하기 위해서 static으로 설정
	static int num2 ; 
	static char cal_ch; 
	
	static int cnt = 0 ; 
	
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
		String tmp_str = str; // inputArea.getText(); 
		tmp_str = tmp_str.substring(0, tmp_str.length()-1); //마지막 엔터 제거
		
		
		switch(cnt) {
			case 1 : setNum1(tmp_str); break;
			case 2 : setCal_ch(tmp_str);break;
			case 3 : setNum2(tmp_str);break;
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
		}catch(NumberFormatException e) {
			System.err.println("숫자가 아닌 값을 입력하셨습니다.");
		}
	}
	
	public void setNum2(String str) {
		try {
			num2 = Integer.parseInt(str); 
		}catch(NumberFormatException e) {
			System.err.println("숫자가 아닌 값을 입력하셨습니다.");
		}
		
	}
	
	public void setCal_ch(String str) {
		if(str.length() > 1) { cal_ch = '?';} //사칙연산 기호가 아닌 경우.
		else { cal_ch = str.charAt(0); }
	}
}
