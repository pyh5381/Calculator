package park;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class CalculatorGui extends JFrame {
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu = new JMenu("MENU");
	
	// CalculatorGui Ŭ������ �ν��Ͻ�ȭ�Ҷ� Frame�� �����ǵ��� �����ڿ� ����
	public CalculatorGui() {
		super("������ ����");
		
		// ���Ŀ� ǥ�ؿ� ����� ���α׷��ӿ� ���⸦ ���� �޴��� �߰�.
		menubar.add(menu);
		setJMenuBar(menubar);
		
		// �����ӿ� ���� ��������.
		setBackground(Color.WHITE);
		setVisible(true);
		setSize(395, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
