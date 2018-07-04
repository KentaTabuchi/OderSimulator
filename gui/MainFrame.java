package gui;

import java.awt.BorderLayout;
import java.io.PrintStream;
import javax.swing.JFrame;

import stage.GameStage;
import stage.StageLv1;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	private final MessagePanel messagePanel = new MessagePanel();
	public MainFrame() {
		
		this.setTitle("発注練習");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		this.getContentPane().setLayout(null);//引数null でアンカーレイアウトみたいになる。
		this.getContentPane().add(new CalendarPanel(new BorderLayout()));
		this.getContentPane().add(messagePanel);
		JTextAreaStream stream = new JTextAreaStream(messagePanel.textArea);
		System.setOut(new PrintStream(stream, true));  
		this.setVisible(true);
	}
	@SuppressWarnings("unused")
	public static void main(String args[]){
		MainFrame mainFrame = new MainFrame();
		
		GameStage gameStage = new StageLv1();
		gameStage.setMaxCustomer();
		gameStage.description();
		gameStage.start();
		
	}

}
