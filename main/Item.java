package main;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 */

/**
 * @author misskabu
 * 納品された商品を表すクラス
 */
public class Item {
	private String name;//品名
	private Date sellBuy; //賞味期限
	private int stockAcceptable;//入荷許容
	private Date deliveryDay; //納品日
	private int leadTime; //LT リードタイム
	private int price; //値段
	
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
		this.name = "パン";
		this.stockAcceptable = 2;
		this.leadTime = 2;
		this.price = 100;
	}
	public Item(String name,int stockAcceptable,int leadTime,int price) {
		this.stockAcceptable = stockAcceptable;
		this.leadTime = leadTime;
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
	

}
