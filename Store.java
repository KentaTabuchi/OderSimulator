import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */

/**
 * @author misskabu
 * お店を表すクラス
 * 商品在庫は陳列棚に格納される
 */
public class Store {

	public SalesData salesData = SalesData.CreateInstance();
	private List<Item> displayCabinet = new ArrayList<Item>(); // 陳列棚
	private static Store store;
	private  Store() {
	}
	public static Store CreateStore(){
		if(store == null){
			store = new Store(); 
			System.out.println("お店が開店しました");
		}
		return store;
	}
	
	
	/**商品を納品して棚に加える
	 * @param item
	 */
	public void addItemToCabinet(Item item) {
		displayCabinet.add(item);
	}
	public int removeItemFromCabinet(Date currentDay){
		int counter=0;
		Iterator<Item> it = displayCabinet.iterator();//イテレータを使わずにリストから直接removeするとリスト内のインデックスが崩れて論理エラーになる。
		
		while(it.hasNext()){
			final Item item = it.next();
			if(item.getSellBuy().equals(currentDay)){
				this.salesData.addDisposal(item);
				counter++;
				it.remove();
			}
		}
		return counter;
	}
	
	public List<Item> getDisplayCabinet(){
		return displayCabinet;
		
	}

	public void showCabinet(){
		System.out.println("----------------陳列棚状況-----------------------");

		for(int i=0;i<displayCabinet.size();i++){
			Item item = displayCabinet.get(i);
			System.out.printf("賞味期限は%tF%n",item.getSellBuy());
		}
	}
	public void showSalesData(){
		System.out.println("----------------販売実績-----------------------");
		System.out.print("販売数合計:"+salesData.getSalesNumber()+"個 ");
		System.out.print("売上高累計:"+salesData.getSalesPrice()+"円 ");
		System.out.print("廃棄数合計:"+salesData.getDisposalNumber()+"個 ");
		System.out.print("廃棄金額累計:"+salesData.getDisposalPrice()+"円 ");
		System.out.print("機会ロス:"+salesData.getChanceLoss()+"個 ");
		System.out.println("在庫数:"+displayCabinet.size()+"個 ");
		
	}
	

}
