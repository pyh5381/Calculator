package park;

public class CalculatorMain {
	public static void main(String[] args) {
		CalculatorGui calculator = new CalculatorGui();
		new StandardPanel(calculator);
	}
}
