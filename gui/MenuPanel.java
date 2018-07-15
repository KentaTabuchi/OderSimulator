package gui;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements ActionListener {

	public MenuPanel() {
	}
//"どうしますか？ 終了：０　続行：1 発注状況：２　在庫状況：３ セーブ:9"
	public MenuPanel(LayoutManager layout) {
		super(layout);
		this.setBounds(PanelPosManager.MENU_PANEL);
		
		JButton button0 = new JButton("終了");
		JButton button1 = new JButton("続行");
		JButton button2 = new JButton("発注状況");
		JButton button3 = new JButton("在庫状況");
		JButton button9 = new JButton("セーブ");
		
		button0.setActionCommand("0");
		button1.setActionCommand("1");
		button2.setActionCommand("2");
		button3.setActionCommand("3");
		button9.setActionCommand("9");
		
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);		
		button9.addActionListener(this);
		
		this.add(button0);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button9);
	
		this.setVisible(false);//普段は見えなくして、入力を求められたら表示する。
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case "0":MainFrame.getInputter().setKey(0);break;
		case "1":MainFrame.getInputter().setKey(1);break;
		case "2":MainFrame.getInputter().setKey(2);break;
		case "3":MainFrame.getInputter().setKey(3);break;
		case "9":MainFrame.getInputter().setKey(9);break;
	}
	
	}

}
