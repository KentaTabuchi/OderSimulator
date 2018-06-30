package main;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 */

/**
 * @author misskabu
 * 納品された商品を表すクラス
 * このクラスの生成はItemFactoryクラスのcreateItemメソッドにて行う
 */
public class Item implements Cloneable{
	
	private static int id = 0;//このアイテムを生成した順にインクリメントするデバッグ用の識別No。
	private String name;//品名
	private Date sellBuy; //賞味期限
	private int stockAcceptable;//入荷許容
	private Date deliveryDay; //納品日
	private int leadTime; //LT リードタイム
	private int price; //値段
	
	public int getId(){
		return id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName(){
		return this.name;
	}
	public Item(){
		Item.id++;
		this.name = "パン";
		this.stockAcceptable = 2;
		this.leadTime = 2;
		this.price = 100;
	}
	/**
	 * @param name 品名
	 * @param stockAcceptable 入荷許容
	 * @param leadTime リードタイム
	 * @param price 売価
	 */
	public Item(String name,int stockAcceptable,int leadTime,int price) {
		Item.id++;
		this.name = name;
		this.stockAcceptable = stockAcceptable;
		this.leadTime = leadTime;
		this.price = price;
	}
		public Date getSellBuy() {
			Calendar cal = Calendar.getInstance();
			cal.setTime(deliveryDay);
			cal.add(Calendar.DATE, this.stockAcceptable);
			this.sellBuy= cal.getTime();
		return sellBuy;
	}

		public Date getDeliveryDay(){
			return deliveryDay;
		}
		public void setDeliveryDay(Date deliveryDay){
			this.deliveryDay = deliveryDay;
			Calendar cal = Calendar.getInstance();
			cal.setTime(deliveryDay);
			cal.add(Calendar.DATE, this.leadTime);
			this.deliveryDay = cal.getTime();
		}
		public int getLeadTime(){
			return leadTime;
		}
		/**名前が同じなら等価とみなす*/
		@Override
		public boolean equals(Object obj) {
			if(this == obj){
				return true;
				}
			if(obj instanceof Item){
				final Item item = (Item)obj;
				if(this.name == item.name){
					return true;
				}
			}
			return false;
		}
		@Override
		public Item clone(){
			Item item = null;
			try{
				item = (Item)super.clone();
				item.name = this.name;
				item.sellBuy = this.sellBuy;
				item.deliveryDay = this.deliveryDay;
				
			}catch(CloneNotSupportedException e){
				e.printStackTrace();
			}
			return item;
		}
	

}
