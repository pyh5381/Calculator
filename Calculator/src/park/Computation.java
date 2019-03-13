package park;

import java.text.DecimalFormat;

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
	
	// 마지막 연산식에 따라 알맞은 연산메소드 호출
	public String calculation(String pre, String post, String last) {
		pre = pre.substring(0, pre.indexOf(" "));
		pre = pre.replaceAll(",", "");
		post = post.replaceAll(",", "");
		
		switch (last) {
			case "+":
				return add(pre, post);
				
			case "-":
				return sub(pre, post);
				
			case "*":
				return mul(pre, post);
				
			case "/":
				return div(pre, post);
				
			default:
				return "Exception";
		}
	}
	
	// 세자리마다 , 찍기
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
