package Calc2;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class CalculatorSwing2 extends JFrame implements KeyListener{
	
	JPanel mainPanel;
	JTextArea inputArea;
	JLabel inputLabel,explainLabel;
	
	Calculator2 cal2 = new Calculator2(); 
	
	public CalculatorSwing2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder("Panel"));
		mainPanel.setLayout(new BorderLayout());
		
		inputArea = new JTextArea();
		inputArea.setBorder(new TitledBorder("input"));
		
		
		explainLabel = new JLabel("수식을 입력해주세요.",JLabel.RIGHT);
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
		
		CalculatorSwing2 cal2 = new CalculatorSwing2();
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("keyTyped");
		
		char key = e.getKeyChar();
		
		
		if(key == 10) { // 
			
			cal2.getInput(inputArea.getText());
			
			cal2.printArr();
			
			//explainLabel.setText("test.");
	
			explainLabel.setText(cal2.doCalculate());
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
