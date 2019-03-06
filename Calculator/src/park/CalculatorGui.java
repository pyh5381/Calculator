package park;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class CalculatorGui extends JFrame {
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu = new JMenu("MENU");
	
	// CalculatorGui 클래스를 인스턴스화할때 Frame이 생성되도록 생성자에 구현
	public CalculatorGui() {
		super("윈도우 계산기");
		
		// 이후에 표준용 계산기와 프로그래머용 계산기를 위해 메뉴바 추가.
		menubar.add(menu);
		setJMenuBar(menubar);
		
		// 프레임에 대한 설정사항.
		setBackground(Color.WHITE);
		setVisible(true);
		setSize(395, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
