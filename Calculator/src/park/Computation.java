package park;

import java.text.DecimalFormat;

import javax.swing.JLabel;

public class Computation {
	private long calResult = 0;
	
	public String add(String pre, String post) {
		calResult = Long.parseLong(pre) + Long.parseLong(post);
		
		return digitNum(String.valueOf(calResult));
	}
	public String sub(String pre, String post) {
		calResult = Long.parseLong(pre) - Long.parseLong(post);
		
		return digitNum(String.valueOf(calResult));
	}
	public String mul(String pre, String post) {
		calResult = Long.parseLong(pre) * Long.parseLong(post);
		
		return digitNum(String.valueOf(calResult));
	}
	public String div(String pre, String post) {
		calResult = Long.parseLong(pre) / Long.parseLong(post);
		
		return digitNum(String.valueOf(calResult));
	}
	
	public void result(JLabel margin, JLabel result) {
		String[] tmp;
		String pre = margin.getText();
		String post = result.getText();
		
		pre = pre.replaceAll(",", "");
		post = post.replaceAll(",", "");
		tmp = pre.split(" ");
		
		if (margin.getText() != "") {
			switch (tmp[1]) {
				case "+":
					result.setText(add(tmp[0], post));
					break;
					
				case "-":
					result.setText(sub(tmp[0], post));
					break;
					
				case "*":
					result.setText(mul(tmp[0], post));
					break;
				case "/":
					result.setText(div(tmp[0], post));
					break;
					
				default:
					break;
			}
		}
		
		margin.setText("");
	}
	
	public String digitNum(String tmpResult) {
		DecimalFormat df = new DecimalFormat("#,###");
		tmpResult = tmpResult.replaceAll(",", "");
		
		return df.format(Long.parseLong(tmpResult));
	}
	
	// 숫자 지울때 사용할 문자열 삭제 메소드
	public String backString(String tmpResult) {
		tmpResult = tmpResult.replaceAll(",", "");
		tmpResult = tmpResult.substring(0, tmpResult.length() - 1);
			
		return digitNum(tmpResult);
	}
}
