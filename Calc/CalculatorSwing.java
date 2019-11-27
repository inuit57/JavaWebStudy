package Calc;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class CalculatorSwing extends JFrame implements KeyListener{
	
	JPanel mainPanel;
	JTextArea inputArea;
	JLabel inputLabel,explainLabel;
	
	//int cnt;
	
	public CalculatorSwing() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder("Panel"));
		mainPanel.setLayout(new BorderLayout());
		
		inputArea = new JTextArea();
		inputArea.setBorder(new TitledBorder("input"));
		
		
		explainLabel = new JLabel("정수를 입력하세요.",JLabel.RIGHT);
		explainLabel.setBorder(new TitledBorder("explain"));
		
		mainPanel.add(inputArea,BorderLayout.NORTH);
		mainPanel.add(explainLabel,BorderLayout.CENTER);
		
		inputArea.addKeyListener(this);
		
		setContentPane(mainPanel);
		
		
		setTitle("Calculator");
		setSize(300, 200);
		setVisible(true);
		
		inputArea.requestFocus();
		
	}
	
	
	public static void main(String[] arg) {
		
		CalculatorSwing cal2 = new CalculatorSwing();
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("keyTyped");
		
		char key = e.getKeyChar();
		
		Calculator MyCal = new Calculator(); 
		
		if(key == 10) { //엔터 입력시 
			
			MyCal.cnt_inc(); // 횟수 증가 
			if(MyCal.getCnt()%2 !=1) {
				explainLabel.setText("정수를 입력하세요.");
			}
			else {
				explainLabel.setText("연산자(+, -, *, /)를 입력하세요.");
			}
			MyCal.setValues(inputArea.getText()); 
			
			if(MyCal.getCnt() >=3) {
				explainLabel.setText(MyCal.calculate()); //화면 출력.
			}
			
			//explainLabel.setText(inputArea.getText());
			inputArea.setText("");
			
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//System.out.println("keyPressed");
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
