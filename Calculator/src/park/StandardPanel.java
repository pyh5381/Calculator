package park;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
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
	private String[] btnName = { "CE", "C", "��", "/"
            					 ,"7", "8", "9", "*"
            					 ,"4", "5", "6", "-"
            					 ,"1", "2", "3", "+"
            					 ,"+-", "0", ".", "=" };
	
	public StandardPanel(CalculatorGui calculator) {
		/*---------- ����� ����� ���� �г� ���� ----------*/
		result.setFont(new Font("����", Font.BOLD, 30));
		result.setBorder(new EmptyBorder(0, 0, 0, 20));
		
		resultPane.add(margin);
		resultPane.add(result);
		calculator.add(resultPane, BorderLayout.NORTH);
		
		/*---------- ��ư ����� ���� �г� ���� ----------*/
		for (int i = 0; i < btnName.length; i++) 
		{
			btn[i] = new JButton(btnName[i]);
			btnPane.add(btn[i]);
			btn[i].setFont(new Font("����", Font.BOLD, 25));
			
			// ���� ��ư�� ������ ��ư�� �ٸ����� �ֱ����� ���ǽ�
			if (Pattern.matches("[0-9]", btnName[i])) {
				btn[i].setBackground(new Color(235, 235, 235));
			}
			else {
				btn[i].setBackground(new Color(220, 220, 220));
			}
			// �ڱ��ڽ��� Override�� ��ưŬ�� �� Ű�����Է� �̺�Ʈ ���� �޼ҵ�� Listener �߰�
			btn[i].addActionListener(this);
			btn[i].addKeyListener(this);
		}
		
		calculator.add(btnPane, BorderLayout.CENTER);
	}
	
	public String digitNum(String tmpResult) {
		DecimalFormat df = new DecimalFormat("#,###");
		tmpResult = tmpResult.replaceAll(",", "");
		
		return df.format(Long.parseLong(tmpResult));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String clickBtn = e.getActionCommand();
		String tmpResult = result.getText();
		
		/*--------- ���� ��ư Ŭ���� ó�� �̺�Ʈ ---------*/
		if (Pattern.matches("[0-9]", clickBtn)) {
			if (tmpResult == "0") {
				result.setText(clickBtn);
			}
			else {
				tmpResult += clickBtn;
				result.setText(digitNum(tmpResult));
			}
		}
		
		/*--------- �׿ܿ� �ٸ� ��ư Ŭ���� ó�� �̺�Ʈ ---------*/
		switch (clickBtn) {
			case "CE":
				result.setText("0");
				break;
			case "C":
				result.setText("0");
				break;
			default:
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String pressBtn = KeyEvent.getKeyText(e.getKeyCode());
		String tmpResult = result.getText();
		
		/*--------- ���� Ű���� �Է½� ó�� �̺�Ʈ ---------*/
		if (Pattern.matches("[0-9]", pressBtn)) {
			if (tmpResult == "0") {
				result.setText(pressBtn);
			}
			else {
				tmpResult += pressBtn;
				result.setText(digitNum(tmpResult));
			}
		}
		
		/*--------- �׿ܿ� Ű���� �Է½� ó�� �̺�Ʈ ---------*/
		
	}
	
	// �Ʒ� 2�� �޼ҵ�� ������� ����
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
}
