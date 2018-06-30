package main;
/**
 * 
 */

/**販売実績を表すクラス。
 * Storeクラスに帰属する。
 * @author misskabu
 *
 */
public class SalesData {
	private static SalesData salesData;
	private int salesNumber = 0;
	private int salesPrice = 0;
	private int disposalNumber = 0;
	private int discountPrice = 0;
	private int disposalPrice = 0;
	private int chanceLoss = 0; //チャンスロス
	private int impairment =0;//売変合計（廃棄＋値引き)
	private double impairmentRatio =0; //売変率
	private SalesData() {
	}
	public static SalesData CreateInstance(){
		if(salesData == null){
			salesData = new SalesData(); 
		}
		return salesData;
	}
	public void addSales(Item item){
			this.salesNumber ++;
			this.salesPrice += item.getPrice();
	}
	public void addDisposal(Item item){
		this.disposalNumber ++;
		this.disposalPrice += item.getPrice();
	}
	public int getSalesNumber(){
		return salesNumber;
	}
	public int getSalesPrice(){
		return salesPrice;
	}
	public int getDisposalNumber(){
		return disposalNumber;
	}
	public int getDisposalPrice(){
		return disposalPrice;
	}
	public int getChanceLoss() {
		return chanceLoss;
	}
	public void addChanceLoss(int chanceLoss) {
		this.chanceLoss += chanceLoss;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void addDiscountPrice(int value) {
		this.discountPrice += value;
	}
	public int getImpairment() {
		impairment = this.discountPrice + this.disposalPrice;
		return impairment;
	}
	public double getImpairmentRatio() {
		impairmentRatio = (double)this.getImpairment() / (double)this.salesPrice ;
		return impairmentRatio;
	}



}
