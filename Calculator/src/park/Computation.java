package park;

import java.text.DecimalFormat;

public class Computation {
	public String add() {
		
		return null;
	}
	public String sub() {
		
		return null;
	}
	public String mul() {
		
		return null;
	}
	public String div() {
		
		return null;
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
