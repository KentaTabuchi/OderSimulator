package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 */

/**お客様を表すクラス
 * お客様は欲しいもの、数量を考え、買い物かごに入れる。
 * 欲しいものが店に陳列されていないとその商品は買えず、不満を覚える。
 * @author misskabu
 *
 */
public class Customer {
	private String name;
	private int maxPurchaseNumber;//一人が買う最大の購入数
	private List<Item> basket = new ArrayList<Item>(); //買い物かごを現すリスト

	public Customer(int maxPurchaseNumber) {
		this.name = "お客様";
		this.maxPurchaseNumber = maxPurchaseNumber;
	}
	public void selectItem(Store store,Item item){
			Random rand = new Random();
			int purchaseNumber = rand.nextInt(maxPurchaseNumber);
			int countStock = store.getDisplayCabinet().size();
			if(purchaseNumber > countStock){
				final int chanceLoss = purchaseNumber - countStock;
				store.salesData.addChanceLoss(chanceLoss);
				System.out.println(this.name + "「後" + chanceLoss + "個欲しかった。");
				purchaseNumber = countStock;
			}
			for (int i=0;i<countStock;i++){
				basket.add(item);
			}
	}
	public List<Item> getBasket(){
		return this.basket;
	}

}
