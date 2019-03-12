package park;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JLabel;

/*
 *  EventProcessing 객체에서 모든 이벤트를 처리하고 처리한 결과출력까지 담당
 */

public class EventProcessing implements ActionListener, KeyListener{
	private boolean check = false;
	
	private JLabel tmpResult;
	private JLabel result;
	private Computation computation;
	
	private String input;
	private String tmp;
	private String complete;
	
	//이벤트 처리시 사용할 결과물 Label들과 연산식이 들어있는 Computation 객체 생성 후 초기화 
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
		
		// 숫자버튼 입력에 대한 처리
		if (Pattern.matches("[0-9]", input)) {
			if (complete.equals("0") || check) {
				result.setText(input);
			}
			else {
				result.setText(computation.digitNum(complete + input));
			}
		}
		
		// 그외 입력버튼에 대한 처리
		if (input.equals("CE") || input.equals("AC")) {
			result.setText("0");
		}
		
		switch (input) {
			case "←":
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
		
		// 숫자 키보드 입력에 대한 처리
		if (Pattern.matches("[0-9]", input)) {
			if (complete.equals("0") || check) {
				result.setText(input);
			}
			else {
				result.setText(computation.digitNum(complete + input));
			}
		}
		
		// 그외 키보드 입력에 대한 처리
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
	
	// 아래 2개 메소드는 사용하지 않음
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
}
