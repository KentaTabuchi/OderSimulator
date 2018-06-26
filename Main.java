import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author misskabu
 *発注サイクルをシミュレーションするプログラム
 */
public class Main {
	private static Date currentDay;//現在日付。これがターンになる。
	private static boolean gameLoopFlg =false;
	public Main() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	Store store = Store.CreateStore();
	Center center = Center.CreateInstance();
	Oderer oderer = new Oderer();
	
	Disposaler disposaler = new Disposaler();
	Calendar cal = Calendar.getInstance();//現在時刻
	
	cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DATE), 0, 0, 0);/*月日だけとって時、分、秒を０に合わせる。そうしないと日付比較した時に論理エラーになる。*/
	currentDay = cal.getTime();
	System.out.printf("%tm月%td日になりました。%n", currentDay,currentDay);

	//------------メインループ----------------------------------
	gameLoopFlg=true;
	try(Scanner scan = new Scanner(System.in)){
		while(gameLoopFlg){
			advanceTheDay(cal);
			System.out.println("どうしますか？ 終了：０　続行：1 発注状況：２　在庫状況：３");
			System.out.print("入力>");
			switch(scan.nextInt()){
			case 0:gameLoopFlg=false;System.out.println("お疲れ様でした。");break;
			case 1:mainTurn(scan,store,center,oderer,disposaler);break;
			case 2:center.showOderList();break;
			case 3:store.showCabinet();break;
			
			}
	
		}
	}
	//----------------------------------------------------------
	}
	private static void mainTurn(Scanner scan,Store store,Center center,Oderer oderer,Disposaler disposaler){
		System.out.println("今日は何個発注しますか？");
		System.out.print("入力>");

		oderer.oderItem(currentDay, center,new Item(),scan.nextInt());
		center.deliveryGoods(store,currentDay);
		commingCustomer(store);//お客様が来て買い物をするシーン
		disposaler.disposal(store, currentDay);
		store.showSalesData();
			
	}
	private static void advanceTheDay(Calendar cal){
		cal.setTime(currentDay);;
		cal.add(Calendar.DATE, 1);
		currentDay = cal.getTime();
		System.out.printf("%tm月%td日になりました。%n", currentDay,currentDay);
	}
	public static void commingCustomer(Store store){
		Random random = new Random();
		final int customerNumber = random.nextInt(10)+5;
		System.out.println(customerNumber+"人来ました");
		for(int i=0;i<customerNumber;i++){
			Customer customer = new Customer(4);
			customer.buyItem(store, new Item());
		} // テスト用モック。このアイテムはランダムで生成するように変える。
	}
	

}
