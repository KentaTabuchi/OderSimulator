package main;
import java.util.Iterator;

/**
 * 
 */

/**レジ番を表すクラス
 * レジ番はお客様が持って来た商品をレジに入力して会計する。
 * @author misskabu
 *
 */
public class Cashier {
	private String name;
	public Cashier() {
		this.name = "レジ担当";
	}
	public Cashier(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	/**会計する様子 
	 */
	public void getTheBill(Customer customer,Store store){

		int countNumber = 0;
		int countPrice = 0;

			customer.greet();
			Iterator<Item> it = customer.getBasket().iterator();
			while(it.hasNext()){
				final Item item = it.next();
				store.salesData.addSales(item);
				countNumber++;
				countPrice += item.getPrice();
				System.out.println(this.name+"「"+item.getName()+"が１点");
			}
			if(countNumber==0){
				customer.askNoMore();
				System.out.println(this.name + "「申し訳ありません。ただいま品切れしております。」");
			}
			else{
				System.out.printf("%s「合計%d点で%d円になります。」%n",this.name,countNumber,countPrice);
			}
		
	}

}
