/**
 * 
 */
package gui;

import java.awt.Color;
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
public class StorePanel extends JPanel{
	JTable table;
	DefaultTableModel model;
	/**
	 * 
	 */
	public StorePanel() {
		this.setBounds(PanelPosManager.STORE_PANEL);
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
		Iterator<Item> it = itemList.iterator();
		while(it.hasNext()){
			final Item item = it.next();
			final String[] record = {item.getName(),item.getSellBuy().toString()};
			model.addRow(record);
		}
	}

}
