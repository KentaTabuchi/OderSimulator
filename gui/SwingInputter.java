package gui;

/**GUIからの入力を受け付けるためのクラス。
 * @author misskabu
 *
 */
public class SwingInputter implements Inputable,Runnable {
	private int key = -1; //他のGUIクラスのボタンなどから受け取った数値を保管する。
	private boolean isLoop = false;
	Thread thread;
	public SwingInputter() {
		
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public  int getInput() {
		isLoop = true;
		MainFrame.getSelectPanel().setVisible(true);
		this.thread = new Thread(this);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MainFrame.getSelectPanel().setVisible(false);

		return key;
	}
	@Override
	public void enter() {
		isLoop = true;
		MainFrame.getOkPanel().setVisible(true);
		this.thread = new Thread(this);
		this.thread.start();
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MainFrame.getOkPanel().setVisible(false);
	}
	public void setKey(int key){
		this.key = key;
		this.thread.interrupt();
	}

	@Override
	public void run() {
		while(this.isLoop){
			try {
				Thread.sleep(1000); //なくてもいいかもしれないけど、キー入力に失敗すると無限ループでアプリ終了できなくなるので、強制終了のタイミングを残している。
			} catch (InterruptedException e) {
				this.isLoop = false;
				//e.printStackTrace(); わざとInterrupterExceptionでループを抜けているのでエラー表示をコメントアウトしている。
			}
		}
		
		
	}



}
