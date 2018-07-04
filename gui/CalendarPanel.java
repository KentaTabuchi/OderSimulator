package gui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarPanel extends JPanel {

	public CalendarPanel() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public CalendarPanel(LayoutManager layout) {
		super(layout);
		this.setBackground(Color.PINK);
		this.setBounds(700, 0, 100, 30);
		final JLabel dayLabel = new JLabel("日付");
		this.add(dayLabel);
		// TODO 自動生成されたコンストラクター・スタブ
	}



}
