/**
 * 
 */
package stage;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import gui.Inputable;
import gui.MainFrame;
import main.Cashier;
import main.Center;
import main.Customer;
import main.Disposaler;
import main.ItemType;
import main.Oderer;
import main.Store;
import save.Save;


/**
 * @author misskabu
 *
 */
public class GameStage {
	private Inputable inputter;
	protected Date currentDay;//現在日付。これがターンになる。
	protected int elapsedDays=0;//経過日数
	protected boolean gameLoopFlg =false;
	protected int maxCustomer;

	public void start(){
		Store store = Store.CreateStore();
		Center center = Center.CreateInstance();
		Oderer oderer = new Oderer();
		Cashier cashier = new Cashier();
		Disposaler disposaler = new Disposaler();
		Calendar cal = Calendar.getInstance();//現在時刻
		
		this.description();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DATE), 0, 0, 0);/*月日だけとって時、分、秒を０に合わせる。そうしないと日付比較した時に論理エラーになる。*/
		currentDay = cal.getTime();
		MainFrame.getCalendarPanel().printDate(currentDay);
		System.out.printf("%tm月%td日スタート。%n", currentDay,currentDay);
		this.maxCustomer = 1;
		gameLoop(cal,store, center, oderer, disposaler, cashier);
	};
	public void description(){
		System.out.println("----------------------------------------------------------------------------------");
		System.out.printf("レベル１。このステージではお客様は一人しか来ません。%nこの人はパンしか買わず最大で４個しか買いません。%n");
		System.out.println("----------------------------------------------------------------------------------");
	};
	public GameStage(Inputable inputter){
		this.inputter = inputter;
	}
	protected void gameLoop(Calendar cal,Store store,Center center,Oderer oderer,Disposaler disposaler,Cashier cashier){
		
		gameLoopFlg=true;
		
			while(gameLoopFlg){
				if(elapsedDays == 0 || elapsedDays == 1){
					openingPrepareation(store, oderer, center);
					this.advanceTheDay(cal);
				}else{
					System.out.println("どうしますか？ 終了：０　続行：1 発注状況：２　在庫状況：３ セーブ:9");
					System.out.print("入力>");
					final int key = this.inputter.getMenuKey();
					switch(key){
					case 0:
						gameLoopFlg=false;
						System.out.println("お疲れ様でした。");break;
					case 1:
						try {
							mainTurn(store,center,oderer,disposaler,cashier);
						} catch (IOException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						advanceTheDay(cal);
						break;
					case 2:
						center.showOderList();break;
					case 3:
						store.showCabinet();break;
					case 9:
						Save.saveToFile();
					}

				}
			}
	}
	/**
	 * 開店準備。初めの２日は発注、納品だけ
	 */
	protected void openingPrepareation(Store store,Oderer oderer,Center center){
		int key = -1;
		if(elapsedDays == 0){
			System.out.println("初回発注お願いします");
			key = inputter.getInputNumber();
		}
		else if(elapsedDays == 1){
			System.out.println("二日目の発注をお願いします。");
			key = inputter.getInputNumber();
		}
		
		System.out.print("入力>");
		System.out.println("メインに復帰:"+key);
		oderer.oderItem(currentDay, center,ItemType.BAKERY,key);
		center.deliveryGoods(store,currentDay);

	}
	private void mainTurn(Store store,Center center,Oderer oderer,Disposaler disposaler,Cashier cashier) throws IOException{
		System.out.println("今日は何個発注しますか？");
		System.out.print("入力>");
		final int key = inputter.getInputNumber();
		oderer.oderItem(currentDay, center,ItemType.BAKERY,key);
		System.out.print("▽");
		inputter.enter();
		center.deliveryGoods(store,currentDay);
		System.out.print("▽");
		inputter.enter();
		commingCustomer(store,cashier);//お客様が来て買い物をするシーン
		System.out.print("▽");
		inputter.enter();
		disposaler.discount(store, currentDay);
		System.out.print("▽");
		inputter.enter();
		disposaler.disposal(store, currentDay);
		store.showSalesData();

	}
	protected void advanceTheDay(Calendar cal){
		cal.setTime(currentDay);;
		cal.add(Calendar.DATE, 1);
		currentDay = cal.getTime();
		MainFrame.getCalendarPanel().printDate(currentDay);
		elapsedDays++;
		System.out.printf("%d日後。%tm月%td日になりました。%n", elapsedDays,currentDay,currentDay);
	}
	public void commingCustomer(Store store,Cashier cashier){
		Random random = new Random();
		final int customerNumber = random.nextInt(this.maxCustomer)+1;
		System.out.println(customerNumber+"人来ました");
		for(int i=0;i<customerNumber;i++){
			Customer customer = new Customer(4);
			customer.selectItem(store); //お客様が商品を選んで
			cashier.getTheBill(customer,store);			//レジへ来た様子。
		} 
	}

}
