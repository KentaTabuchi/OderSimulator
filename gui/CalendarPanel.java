package gui;

import java.awt.Color;
import java.awt.LayoutManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CalendarPanel extends JPanel {
	
	private final JLabel dateLabel = new JLabel("日付");
	
	public CalendarPanel() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public CalendarPanel(LayoutManager layout) {
		super(layout);
		this.setBackground(Color.PINK);
		this.setBounds(PanelPosManager.CALENDAR_PANEL);
		
		this.add(this.dateLabel);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void printDate(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("MM'月'dd'日'");
		final String text = dateFormat.format(date);
		this.dateLabel.setText(text);
	}




}
