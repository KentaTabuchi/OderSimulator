package main;
import java.util.Date;

/**
 * 
 */

/**
 * @author misskabu
 *　日切れを廃棄する人
 */
public class Disposaler {
	private String name;
	
	public Disposaler(String name) {
	this.name=name;	
	System.out.println(name+"さんが廃棄します");
	}
	public Disposaler(){
		this.name="廃棄担当";
	}
	
	/**店の在庫リストをチェックして期限がきた商品を廃棄する
	 * @param store
	 * @param currentDay
	 */
	public void disposal(Store store,Date currentDay){
		System.out.printf("%s「%tm月%td日が賞味期限の商品を廃棄します。」%n", name,currentDay,currentDay);
		final int counter = store.removeItemFromCabinet(currentDay);	
		if(counter==0){
			System.out.println(this.name+"「廃棄はありませんでした」");
			}
		else{
			System.out.println(this.name+"「"+counter+"個廃棄しました。」");
		}
	}
	public void discount(Store store,Date currentDay){
		System.out.printf("値引き見て来ます。」%n", name,currentDay,currentDay);
		final int counter = store.discountItemFromCabinet(currentDay);
		if(counter==0){
			System.out.println(this.name+"「値引きはありませんでした」");
			}
		else{
			System.out.println(this.name+"「"+counter+"個値引きしました。」");
		}
	}

}
