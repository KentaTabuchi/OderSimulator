package main;
import java.util.Date;

/**
 * 
 */

/**
 * @author misskabu
 *　発注者を表すクラス
 */
public class Oderer {
	private String name;

	public Oderer() {
		this.name = "発注担当";
	}
	public Oderer(String name){
		this.name = name;
		System.out.println(this.name+"が発注します");
	}
	/**発注するシーン。ここでItemが生成される。
	 * @param currentday
	 * @param center
	 * @param item 
	 * @param number　何個発注するか
	 */
	public void oderItem(Date currentday,Center center,ItemType type,int number){
		ItemFactory factory = new ItemFactory();
		int counter = 0;
		Item item = null;
		for(int i=0;i<number;i++){
			item = factory.createItem(type);
			item.setDeliveryDay(currentday);
			center.receveOder(item);
			counter++;
		}
		System.out.println(this.name+"「"+item.getName()+"を"+counter+"個発注しました。」");
	}

}
