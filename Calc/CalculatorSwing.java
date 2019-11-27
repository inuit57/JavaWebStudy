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
		
		
		explainLabel = new JLabel("������ �Է��ϼ���.",JLabel.RIGHT);
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
		
		if(key == 10) { //���� �Է½� 
			
			MyCal.cnt_inc(); // Ƚ�� ���� 
			if(MyCal.getCnt()%2 !=1) {
				explainLabel.setText("������ �Է��ϼ���.");
			}
			else {
				explainLabel.setText("������(+, -, *, /)�� �Է��ϼ���.");
			}
			MyCal.setValues(inputArea.getText()); 
			
			if(MyCal.getCnt() >=3) {
				explainLabel.setText(MyCal.calculate()); //ȭ�� ���.
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
