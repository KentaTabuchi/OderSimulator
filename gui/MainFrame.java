package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.PrintStream;
import javax.swing.JFrame;

import stage.GameStage;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	private static SwingInputter inputter = new SwingInputter();
	private static MenuButtonPanel menuPanel = new MenuButtonPanel(new FlowLayout());
	private static OKButtonPanel okPanel = new OKButtonPanel();
	private final MessagePanel messagePanel = new MessagePanel();
	
	public MainFrame() {
		this.setTitle("発注練習");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.getContentPane().setLayout(null);//引数null でアンカーレイアウトみたいになる。
		this.getContentPane().add(new CalendarPanel(new BorderLayout()));
		this.getContentPane().add(messagePanel);
		this.getContentPane().add(menuPanel);
		this.getContentPane().add(okPanel);
		JTextAreaStream stream = new JTextAreaStream(messagePanel.textArea);
		System.setOut(new PrintStream(stream, true));  
		this.setVisible(true);
	}
	@SuppressWarnings("unused")
	public static void main(String args[]){
		MainFrame mainFrame = new MainFrame();
		GameStage gameStage = new GameStage(MainFrame.getInputter());
		gameStage.start();
		
	}
	public static SwingInputter getInputter() {
		return inputter;
	}
	public static MenuButtonPanel getMenuPanel() {
		return menuPanel;
	}
	public static OKButtonPanel getOkPanel() {
		return okPanel;
	}

}
