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
 *   StandardPanel ���Դ� �ִ��� Panel ���� �������� å�������� ����
 */

@SuppressWarnings("serial")
public class StandardPanel extends JPanel {
	private JLabel tmpResult = new JLabel("", JLabel.RIGHT);
	private JLabel result = new JLabel("0", JLabel.RIGHT);
	private JPanel btnPanel = new JPanel(new GridLayout(5, 4, 1, 1));
	private EventProcessing event = new EventProcessing(tmpResult, result);
	
	private JButton[] btn = new JButton[20];
	private String[] btnName = { "CE", "AC", "��", "/"
            					 ,"7", "8", "9", "*"
            					 ,"4", "5", "6", "-"
            					 ,"1", "2", "3", "+"
            					 ,"+-", "0", ".", "=" };
	
	public StandardPanel(CalculatorGui calculator) {
		// ����� ����� ���� �г� ����
		result.setFont(new Font("����", Font.BOLD, 30));
		result.setBorder(new EmptyBorder(0, 0, 0, 20));
		
		setLayout(new GridLayout(2, 1));
		add(tmpResult);
		add(result);
		
		calculator.add(this, BorderLayout.NORTH);
		
		// ��ư ����� ���� �г� ����
		for (int i = 0; i < btnName.length; i++) 
		{
			btn[i] = new JButton(btnName[i]);
			btnPanel.add(btn[i]);
			btn[i].setFont(new Font("����", Font.BOLD, 25));
			
			// ���� ��ư�� ������ ��ư�� �ٸ����� �ֱ����� ���ǽ�
			if (Pattern.matches("[0-9]", btnName[i])) {
				btn[i].setBackground(new Color(235, 235, 235));
			}
			else {
				btn[i].setBackground(new Color(220, 220, 220));
			}
			
			// ��ưŬ���� �߻��ϴ� �̺�Ʈ && ��Ŀ���� ��ư�� �������� Ű���� �Է��� �ޱ����� �̺�Ʈ�� event ��ü�� ����
			btn[i].addActionListener(event);
			btn[i].addKeyListener(event);
		}
		
		// ���������ӿ��� �߻��ϴ� Ű���� �Է¿����� Listener ���
		calculator.addKeyListener(event);
		calculator.add(btnPanel, BorderLayout.CENTER);
	}
}
