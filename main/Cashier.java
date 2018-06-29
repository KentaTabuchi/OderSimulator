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
		System.out.println(customer.getName()+"「これください。」");
		Iterator<Item> it = customer.getBasket().iterator();
		while(it.hasNext()){
			final Item item = it.next();
			store.salesData.addSales(item);
			countNumber++;
			countPrice += item.getPrice();
		}
		if(countNumber==0){
			System.out.println(this.name + "「申し訳ありません。ただいま品切れしております。」");
		}
		else{
			System.out.printf("%s「%d点で%d円になります。」%n",this.name,countNumber,countPrice);
		}
	}

}
