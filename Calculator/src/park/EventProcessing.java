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
	private String charKey;
	private String lastOperator;
	
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
				check = false;
			}
			else {
				result.setText(computation.digitNum(complete + input));
			}
		}
		
		// �׿� �Է¹�ư�� ���� ó��
		if (input.equals("CE") || input.equals("AC")) {
			result.setText("0");
		}
		
		if (Pattern.matches("[+|*|/|-]", input)) {
			tmpResult.setText(tmp + complete + " " + input + " ");
			check = true;
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
			case "=":
				complete = computation.calculation(tmp, complete, lastOperator);
				result.setText(complete);
				tmpResult.setText("");
				check = true;
				break;
			default:
				break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		input = KeyEvent.getKeyText(e.getKeyCode());
		charKey = String.valueOf(e.getKeyChar());
		tmp = tmpResult.getText();
		complete = result.getText();
		
		// ���� Ű���� �Է¿� ���� ó��
		if (Pattern.matches("[0-9]", charKey)) {
			if (complete.equals("0") || check) {
				result.setText(input);
				check = false;
			}
			else {
				result.setText(computation.digitNum(complete + input));
			}
		}
				
		// �׿� Ű���� �Է¿� ���� ó��
		if (Pattern.matches("[+|/|*|-]", charKey)) {
			tmpResult.setText(tmp + complete + " " + charKey + " ");
			check = true;
			lastOperator = charKey;
		}
		
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
			case "Enter":
				complete = computation.calculation(tmp, complete, lastOperator);
				result.setText(complete);
				tmpResult.setText("");
				check = true;
				break;
			default:
				break;
		}
	}
	
	// �Ʒ� �޼ҵ�� ������� ����
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
}
