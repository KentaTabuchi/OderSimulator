/**
 * 
 */

/**お客様を表すクラス
 * お客様が買い物をすると売り上げが上がり、商品が減る。
 * 
 * @author misskabu
 *
 */
public class Customer {
	private int purchaseNumber;//一人が買う購入数

	public Customer(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	public void buyItem(Store store,Item item){
		store.salesData.addSales(item,this.purchaseNumber);
	}

}
