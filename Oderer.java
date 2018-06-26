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
	/**
	 * @param currentday
	 * @param center
	 * @param item 
	 * @param number　何個発注するか
	 */
	public void oderItem(Date currentday,Center center,Item item,int number){
		int counter = 0;
		for(int i=0;i<number;i++){
			item.setDeliveryDay(currentday);
			center.receveOder(item);
			counter++;
		}
		System.out.println(this.name+"「"+counter+"個発注しました。」");
	}

}
