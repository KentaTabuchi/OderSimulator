/**
 * 
 */
package gui;

/*ユーザーからの入力を抽象化するインターフェース
 * コマンドラインとSwingGUIのマルチプラットフォームのためのもの。
 * @author misskabu
 *
 */
public interface Inputable {
	public int getInputNumber();	//0から10の数値入力を取得
	public int getMenuKey(); //固定されたメニュー番号を取得
	public void enter();	//値を取得せず、ただメッセージを進めるためのメソッド。
}
