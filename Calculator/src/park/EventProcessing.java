package park;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JLabel;

/*
 *  EventProcessing ��ü���� ��� �̺�Ʈ�� ó���ϰ� ó���� �����±��� ���
 */

public class EventProcessing implements ActionListener, KeyListener{
	private boolean check = false;
	
	private JLabel tmpResult;
	private JLabel result;
	private Computation computation;
	
	private String input;
	private String tmp;
	private String complete;
	
	//�̺�Ʈ ó���� ����� ����� Label��� ������� ����ִ� Computation ��ü ���� �� �ʱ�ȭ 
	public EventProcessing(JLabel tmpResult, JLabel result) {
		this.tmpResult = tmpResult;
		this.result = result;
		computation = new Computation();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		input = e.getActionCommand();
		tmp = tmpResult.getText();
		complete = result.getText();
		
		// ���ڹ�ư �Է¿� ���� ó��
		if (Pattern.matches("[0-9]", input)) {
			if (complete.equals("0") || check) {
				result.setText(input);
			}
			else {
				result.setText(computation.digitNum(complete + input));
			}
		}
		
		// �׿� �Է¹�ư�� ���� ó��
		if (input.equals("CE") || input.equals("AC")) {
			result.setText("0");
		}
		
		switch (input) {
			case "��":
				if (complete.length() != 1) {
					result.setText(computation.backString(complete));
				}
				else {
					result.setText("0");
				}
				break;
			case "+":
				break;
			case "-":
				break;
			case "*":
				break;
			case "/":
				break;
			default:
				break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		input = KeyEvent.getKeyText(e.getKeyCode());
		tmp = tmpResult.getText();
		complete = result.getText();
		
		// ���� Ű���� �Է¿� ���� ó��
		if (Pattern.matches("[0-9]", input)) {
			if (complete.equals("0") || check) {
				result.setText(input);
			}
			else {
				result.setText(computation.digitNum(complete + input));
			}
		}
		
		// �׿� Ű���� �Է¿� ���� ó��
		switch (input) {
			case "Backspace":
				if (complete.length() != 1) {
					result.setText(computation.backString(complete));
				}
				else {
					result.setText("0");
				}
				break;
			case "Escape":
				result.setText("0");
				break;
			default:
				break;
		}
		
		switch (e.getKeyChar()) {
			case '+':
				break;
			case '-':
				break;
			case '*':
				break;
			case '/':
				break;
			default:
				break;
		}
	}
	
	// �Ʒ� 2�� �޼ҵ�� ������� ����
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
}
