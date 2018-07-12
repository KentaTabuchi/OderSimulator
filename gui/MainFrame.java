package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.PrintStream;
import javax.swing.JFrame;

import stage.GameStage;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	private static SwingInputter inputter = new SwingInputter();
	private static SelectNumberPanel selectNumberPanel = new SelectNumberPanel(new FlowLayout());
	private static MenuPanel menuPanel = new MenuPanel(new FlowLayout());
	private static OKButtonPanel okPanel = new OKButtonPanel();
	private static StorePanel storePanel = new StorePanel();
	private static CenterPanel centerPanel = new CenterPanel();
	private final MessagePanel messagePanel = new MessagePanel();
	
	
	public MainFrame() {
		this.setTitle("発注練習");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.getContentPane().setLayout(null);//引数null でアンカーレイアウトみたいになる。
		this.getContentPane().add(new CalendarPanel(new BorderLayout()));
		this.getContentPane().add(messagePanel);
		this.getContentPane().add(selectNumberPanel);
		this.getContentPane().add(okPanel);
		this.getContentPane().add(menuPanel);
		this.getContentPane().add(storePanel);
		this.getContentPane().add(centerPanel);
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
	public static SelectNumberPanel getSelectPanel() {
		return selectNumberPanel;
	}
	public static OKButtonPanel getOkPanel() {
		return okPanel;
	}
	public static MenuPanel getMenuPanel() {
		return menuPanel;
	}
	public MessagePanel getMessagePanel() {
		return messagePanel;
	}
	public static StorePanel getStorePanel() {
		return storePanel;
	}
	public static CenterPanel getCenterPanel() {
		return centerPanel;
	}

}
