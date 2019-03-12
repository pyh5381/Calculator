package park;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
 *   StandardPanel 에게는 최대한 Panel 관련 설정만을 책임지도록 변경
 */

@SuppressWarnings("serial")
public class StandardPanel extends JPanel {
	private JLabel tmpResult = new JLabel("", JLabel.RIGHT);
	private JLabel result = new JLabel("0", JLabel.RIGHT);
	private JPanel btnPanel = new JPanel(new GridLayout(5, 4, 1, 1));
	private EventProcessing event = new EventProcessing(tmpResult, result);
	
	private JButton[] btn = new JButton[20];
	private String[] btnName = { "CE", "AC", "←", "/"
            					 ,"7", "8", "9", "*"
            					 ,"4", "5", "6", "-"
            					 ,"1", "2", "3", "+"
            					 ,"+-", "0", ".", "=" };
	
	public StandardPanel(CalculatorGui calculator) {
		// 결과물 출력을 위한 패널 설정
		result.setFont(new Font("나눔", Font.BOLD, 30));
		result.setBorder(new EmptyBorder(0, 0, 0, 20));
		
		setLayout(new GridLayout(2, 1));
		add(tmpResult);
		add(result);
		
		calculator.add(this, BorderLayout.NORTH);
		
		// 버튼 출력을 위한 패널 설정
		for (int i = 0; i < btnName.length; i++) 
		{
			btn[i] = new JButton(btnName[i]);
			btnPanel.add(btn[i]);
			btn[i].setFont(new Font("나눔", Font.BOLD, 25));
			
			// 숫자 버튼과 나머지 버튼에 다른색을 주기위한 조건식
			if (Pattern.matches("[0-9]", btnName[i])) {
				btn[i].setBackground(new Color(235, 235, 235));
			}
			else {
				btn[i].setBackground(new Color(220, 220, 220));
			}
			
			// 버튼클릭시 발생하는 이벤트 && 포커스가 버튼에 있을때도 키보드 입력을 받기위한 이벤트를 event 객체에 위임
			btn[i].addActionListener(event);
			btn[i].addKeyListener(event);
		}
		
		// 메인프레임에서 발생하는 키보드 입력에대한 Listener 등록
		calculator.addKeyListener(event);
		calculator.add(btnPanel, BorderLayout.CENTER);
	}
}
