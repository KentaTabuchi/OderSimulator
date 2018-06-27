/**
 * 
 */
package stage;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import main.Cashier;
import main.Center;
import main.Customer;
import main.Disposaler;
import main.Item;
import main.Oderer;
import main.Store;


/**
 * @author misskabu
 *
 */
public abstract class GameStage {
	protected Date currentDay;//現在日付。これがターンになる。
	protected boolean gameLoopFlg =false;

	public abstract void start();
	protected void gameLoop(Calendar cal,Store store,Center center,Oderer oderer,Disposaler disposaler,Cashier cashier){
		gameLoopFlg=true;
		try(Scanner scan = new Scanner(System.in)){
			while(gameLoopFlg){

				System.out.println("どうしますか？ 終了：０　続行：1 発注状況：２　在庫状況：３");
				System.out.print("入力>");
				switch(scan.nextInt()){
				case 0:
					gameLoopFlg=false;
					System.out.println("お疲れ様でした。");break;
				case 1:
					advanceTheDay(cal);
					mainTurn(scan,store,center,oderer,disposaler,cashier);break;
				case 2:
					center.showOderList();break;
				case 3:
					store.showCabinet();break;

				}

			}
		}
	}
	private void mainTurn(Scanner scan,Store store,Center center,Oderer oderer,Disposaler disposaler,Cashier cashier){
		System.out.println("今日は何個発注しますか？");
		System.out.print("入力>");

		oderer.oderItem(currentDay, center,new Item(),scan.nextInt());
		center.deliveryGoods(store,currentDay);
		commingCustomer(store,cashier);//お客様が来て買い物をするシーン
		disposaler.disposal(store, currentDay);
		store.showSalesData();
			
	}
	protected void advanceTheDay(Calendar cal){
		cal.setTime(currentDay);;
		cal.add(Calendar.DATE, 1);
		currentDay = cal.getTime();
		System.out.printf("%tm月%td日になりました。%n", currentDay,currentDay);
	}
	public void commingCustomer(Store store,Cashier cashier){
		Random random = new Random();
		final int customerNumber = random.nextInt(3)+1;
		System.out.println(customerNumber+"人来ました");
		for(int i=0;i<customerNumber;i++){
			Customer customer = new Customer(4);
			customer.selectItem(store, new Item()); //お客様が商品を選んで
			cashier.getTheBill(customer,store);			//レジへ来た様子。
		} // テスト用モック。このアイテムはランダムで生成するように変える。
	}
	
}
