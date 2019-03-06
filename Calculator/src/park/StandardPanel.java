package park;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StandardPanel implements ActionListener, KeyListener {
	private JLabel margin = new JLabel("", JLabel.RIGHT);
	private JLabel result = new JLabel("0", JLabel.RIGHT);
	private JPanel resultPane = new JPanel(new GridLayout(2, 1));;
	private JPanel btnPane = new JPanel(new GridLayout(5, 4, 1, 1));
	
	private JButton[] btn = new JButton[20];
	private String[] btnName = { "CE", "C", "☜", "/"
            					 ,"7", "8", "9", "*"
            					 ,"4", "5", "6", "-"
            					 ,"1", "2", "3", "+"
            					 ,"+-", "0", ".", "=" };
	
	public StandardPanel(CalculatorGui calculator) {
		/*---------- 결과물 출력을 위한 패널 설정 ----------*/
		result.setFont(new Font("나눔", Font.BOLD, 30));
		result.setBorder(new EmptyBorder(0, 0, 0, 20));
		
		resultPane.add(margin);
		resultPane.add(result);
		calculator.add(resultPane, BorderLayout.NORTH);
		
		/*---------- 버튼 출력을 위한 패널 설정 ----------*/
		for (int i = 0; i < btnName.length; i++) {
			btn[i] = new JButton(btnName[i]);
			btnPane.add(btn[i]);
			btn[i].setFont(new Font("나눔", Font.BOLD, 25));
			
			if (Pattern.matches("[0-9]", btnName[i])) {
				btn[i].setBackground(new Color(235, 235, 235));
			}
			else {
				btn[i].setBackground(new Color(220, 220, 220));
			}
		}
		
		calculator.add(btnPane, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	// 아래 2개 메소드는 사용하지 않음
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
}
