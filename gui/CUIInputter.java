package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**コマンドラインから数値入力を受け取るクラス。
 * @author misskabu
 *
 */
public class CUIInputter implements Inputable {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public CUIInputter() {
	}

	@SuppressWarnings("resource")
	@Override
	public int getInput() {
		Scanner scan = new Scanner(System.in);
		final int key = scan.nextInt();
		return key;
	}

	@Override
	public void enter() {
		
		try {
			reader.read();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
