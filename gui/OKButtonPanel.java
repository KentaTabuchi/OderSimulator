package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OKButtonPanel extends JPanel implements ActionListener {

	public OKButtonPanel() {
		super();
		this.setBounds(100, 400, 600, 50);
		JButton button = new JButton("OK");
		button.setActionCommand("OK");
		this.add(button);
		button.addActionListener(this);
		this.setVisible(false);//普段は見えなくして、入力を求められたら表示する。
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInputter().setKey(-1);
		
	}

}
