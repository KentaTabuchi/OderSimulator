package main;

import gui.CUIInputter;
import stage.GameStage;

/**
 * @author misskabu
 *発注サイクルをシミュレーションするプログラム
 *メインクラスは本体のGameStageを選んで起動するだけ。
 */
public class Main {

	public Main() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameStage gameStage = new GameStage(new CUIInputter());
		gameStage.start();
	}
}
