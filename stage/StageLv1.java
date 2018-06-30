/**
 * 
 */
package stage;

import java.util.Calendar;

import main.Cashier;
import main.Center;
import main.Disposaler;
import main.Oderer;
import main.Store;

/**
 * @author misskabu
 *
 */
public class StageLv1 extends GameStage{

	/**
	 * 
	 */
	public StageLv1() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void start(){
		Store store = Store.CreateStore();
		Center center = Center.CreateInstance();
		Oderer oderer = new Oderer();
		Cashier cashier = new Cashier();
		Disposaler disposaler = new Disposaler();
		Calendar cal = Calendar.getInstance();//現在時刻
		
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DATE), 0, 0, 0);/*月日だけとって時、分、秒を０に合わせる。そうしないと日付比較した時に論理エラーになる。*/
		currentDay = cal.getTime();
		System.out.printf("%tm月%td日スタート。%n", currentDay,currentDay);

		gameLoop(cal,store, center, oderer, disposaler, cashier);
		
	}
	@Override
	public void setMaxCustomer() {
		this.maxCustomer = 1;
	}
	@Override
	public void description() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("----------------------------------------------------------------------------------");
		System.out.printf("レベル１。このステージではお客様は一人しか来ません。%nこの人はパンしか買わず最大で４個しか買いません。%n");
		System.out.println("----------------------------------------------------------------------------------");
	}

}
