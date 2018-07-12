/**
 * 
 */
package gui;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Item;

/**店の店状況を表示するパネル
 * @author misskabu
 *
 */
@SuppressWarnings("serial")
public class CenterPanel extends JPanel{
	JTable table;
	DefaultTableModel model;
	/**
	 * 
	 */
	public CenterPanel() {
		this.setBounds(PanelPosManager.CENTER_PANEL);
		this.setBackground(Color.CYAN);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		model = new DefaultTableModel();
		model.addColumn("品名");
		model.addColumn("賞味期限");
		table = new JTable(model);
		final JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
	}

	/**リストの内容を表に表示する。
	 * @param itemList
	 */
	public void repaintTable(List<Item> itemList){
		model.setRowCount(0);
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("MM'月'dd'日'");
		Iterator<Item> it = itemList.iterator();
		while(it.hasNext()){
			final Item item = it.next();
			final String sellBuy = dateFormat.format(item.getSellBuy());
			final String[] record = {item.getName(),sellBuy};
			model.addRow(record);
		}
	}

}
