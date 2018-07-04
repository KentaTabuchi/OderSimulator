/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**会話メッセージを表示するパネル。
 * @author misskabu
 *
 */
public class MessagePanel extends JPanel {

	/**
	 * 
	 */
	public final JTextArea textArea;
	public MessagePanel() {
		this.setBounds(100, 220, 600, 150);
		this.setBackground(Color.CYAN);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		textArea = new JTextArea();
		textArea.setEditable(false);
		final JScrollPane scrollPane = new JScrollPane(textArea);
		this.add(scrollPane);
	}






}
