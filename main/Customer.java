package main;
import java.util.ArrayList;
import java.util.Iterator;
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
	private int shortage;//買いたいものの不足数
	private int maxPurchaseNumber;//一人が買う最大の購入数
	private List<Item> basket = new ArrayList<Item>(); //買い物かごを現すリスト

	public Customer(int maxPurchaseNumber) {
		this.name = "お客様";
		this.maxPurchaseNumber = maxPurchaseNumber;
	}
	public String getName(){
		return this.name;
	}
	/**お客様が商品をカゴに入れていくところ
	 * @param store
	 */
	public void selectItem(Store store){
			Random rand = new Random();
			int purchaseNumber = rand.nextInt(maxPurchaseNumber);
			int counter = 0;
			Iterator<Item> it = store.getDisplayCabinet().iterator();
			Random randomType = new Random();
			while(it.hasNext()){
				final int typeIndex = randomType.nextInt(2);
				ItemType type = ItemType.values()[typeIndex];
				System.out.println(type.getName()+"が欲しいなあ。");
				final Item item = it.next();
				if(0 < purchaseNumber){

					if(item.getName()==type.getName()){
						this.basket.add(item);
						it.remove();
						purchaseNumber--;
					}
					counter++;
				}
			}
			shortage = purchaseNumber-counter;
			if(0 < shortage){
			System.out.printf("%s「あと%d欲しかったな」%n",this.name,shortage);
			store.salesData.addChanceLoss(shortage);}
	}
	public void greet(){
		System.out.println(this.getName()+"これください。");
	}
	/**
	 * 商品がないと怒って帰る。
	 */
	public void angry(){
		System.out.println(this.getName()+"「全然ないやん。帰るわ。」");
	}
	/**
	 *商品が欲しい数に足りないともっとないか聞く
	 */
	public void askNoMore(){
		System.out.println(this.getName() + "「もうないの？』" );
	}
	public List<Item> getBasket(){
		return this.basket;
	}
	public int getShortage(){
		return shortage;
	}

}
