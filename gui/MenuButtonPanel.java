package gui;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuButtonPanel extends JPanel implements ActionListener {

	public MenuButtonPanel() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public MenuButtonPanel(LayoutManager layout) {
		super(layout);
		this.setBounds(100, 400, 600, 50);
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		button1.setActionCommand("button1");
		button2.setActionCommand("button2");
		button1.addActionListener(this);
		button2.addActionListener(this);
		this.add(button1);
		this.add(button2);
		this.setVisible(false);//普段は見えなくして、入力を求められたら表示する。
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case "button1":MainFrame.getInputter().setKey(1);break;
		case "button2":MainFrame.getInputter().setKey(2);break;
		}
		System.out.println("入力Keyは"+MainFrame.getInputter().getInput());
	}
	


}
