package gui;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectNumberPanel extends JPanel{

	public SelectNumberPanel() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public SelectNumberPanel(LayoutManager layout) {
		super(layout);
		this.setBounds(PanelPosManager.SELECT_NUMBER_PANEL);
		for(int i=0; i< 11; i++){
			final String caption = String.valueOf(i);
			final int key = i;
			JButton button = new JButton(caption);
			button.setActionCommand(caption);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){ 
					MainFrame.getInputter().setKey(key);	//ボタンイベント
				}
			});
			this.add(button);
		}
		this.setVisible(false);//普段は見えなくして、入力を求められたら表示する。
	}
	
}
