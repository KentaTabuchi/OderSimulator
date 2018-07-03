/**
 * 
 */
package stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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
public abstract class GameStage {
	protected Date currentDay;//現在日付。これがターンになる。
	protected int elapsedDays=0;//経過日数
	protected boolean gameLoopFlg =false;
	protected int maxCustomer;
	BufferedReader reader;
	public abstract void setMaxCustomer();

	public abstract void start();
	public abstract void description();
	public GameStage(){
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	protected void gameLoop(Calendar cal,Store store,Center center,Oderer oderer,Disposaler disposaler,Cashier cashier){
		
		gameLoopFlg=true;
		try(Scanner scan = new Scanner(System.in)){
			while(gameLoopFlg){
				if(elapsedDays == 0 || elapsedDays == 1){
					openingPrepareation(scan,store, oderer, center);
					this.advanceTheDay(cal);
				}else{
					System.out.println("どうしますか？ 終了：０　続行：1 発注状況：２　在庫状況：３ セーブ:9");
					System.out.print("入力>");
					switch(scan.nextInt()){
					case 0:
						gameLoopFlg=false;
						System.out.println("お疲れ様でした。");break;
					case 1:
						mainTurn(scan,store,center,oderer,disposaler,cashier);
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
		}catch(InputMismatchException e){
			System.out.println("半角で数字を入力してください。");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	/**
	 * 開店準備。初めの２日は発注、納品だけ
	 */
	protected void openingPrepareation(Scanner scan,Store store,Oderer oderer,Center center){
		if(elapsedDays == 0){
			System.out.println("初回発注お願いします");
		}
		else if(elapsedDays == 1){
			System.out.println("二日目の発注をお願いします。");
		}
		System.out.print("入力>");
		oderer.oderItem(currentDay, center,ItemType.BAKERY,scan.nextInt());
		center.deliveryGoods(store,currentDay);

	}
	private void mainTurn(Scanner scan,Store store,Center center,Oderer oderer,Disposaler disposaler,Cashier cashier) throws IOException{
		System.out.println("今日は何個発注しますか？");
		System.out.print("入力>");

		oderer.oderItem(currentDay, center,ItemType.BAKERY,scan.nextInt());
		System.out.print("▽");reader.read();
		center.deliveryGoods(store,currentDay);
		System.out.print("▽");reader.read();
		commingCustomer(store,cashier);//お客様が来て買い物をするシーン
		System.out.print("▽");reader.read();
		disposaler.discount(store, currentDay);
		System.out.print("▽");reader.read();
		disposaler.disposal(store, currentDay);
		store.showSalesData();

	}
	protected void advanceTheDay(Calendar cal){
		cal.setTime(currentDay);;
		cal.add(Calendar.DATE, 1);
		currentDay = cal.getTime();
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
