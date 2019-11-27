package Calc;

public class Calculator {

	static int num1 ; //���� ����ϵ��� �ϱ� ���ؼ� static���� ����
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
		tmp_str = tmp_str.substring(0, tmp_str.length()-1); //������ ���� ����
		
		
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
			System.err.println("���ڰ� �ƴ� ���� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void setNum2(String str) {
		try {
			num2 = Integer.parseInt(str); 
		}catch(NumberFormatException e) {
			System.err.println("���ڰ� �ƴ� ���� �Է��ϼ̽��ϴ�.");
		}
		
	}
	
	public void setCal_ch(String str) {
		if(str.length() > 1) { cal_ch = '?';} //��Ģ���� ��ȣ�� �ƴ� ���.
		else { cal_ch = str.charAt(0); }
	}
}
