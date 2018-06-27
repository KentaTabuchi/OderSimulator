package main;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */

/**
 * @author misskabu
 * 倉庫センターを表すクラス
 * 発注者から受け取ったオーダーを納品日に店に送る
 */
public class Center {
	private List<Item> oderList = new ArrayList<Item>();
	private static Center center;
	private Center() {}
	public static Center CreateInstance(){
		if(center==null){center = new Center();}
		return center;
	}
	
	public void receveOder(Item item){
		this.oderList.add(item);
	}
	/**納品日がきたら発注リストから対象商品を陳列リストへ写した後、対象品目は発注リストから除外。
	 * @param store
	 * @param currentday
	 */
	public void deliveryGoods(Store store,Date currentday){
		int counter=0;

		Iterator<Item> it = oderList.iterator();
		while(it.hasNext()){
			final Item item = it.next();
			if(item.getDeliveryDay().equals(currentday)){
				store.addItemToCabinet(item);
				it.remove();
				counter++;
			}	
		}
		if(counter!=0){
		System.out.println("センター「"+counter+"個発送しました。」");
		}
	}
	public void showOderList(){
		System.out.println("----------------発注状況-----------------------");

		for(int i=0;i<oderList.size();i++){
			Item item = oderList.get(i);
			System.out.println("納品日"+item.getDeliveryDay());
		}
	}
	

}
