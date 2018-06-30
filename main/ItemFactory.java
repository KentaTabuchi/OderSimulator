/**
 * 
 */
package main;

import java.util.HashMap;
import java.util.Map;

/**商品(Itemクラス)を生成する工場。Itemは直接Newせずにこっちから呼ぶ。
 * プロトタイプパターン
 * @author misskabu
 *
 */
public class ItemFactory {
	Map<ItemType,Item> map = new HashMap<ItemType,Item>();
	public ItemFactory() {
		registerItem();
	}
	/**
	 * 商品マスタを登録
	 */
	private void registerItem(){
		map.put(ItemType.BAKERY, new Item(ItemType.BAKERY.getName(),2,2,100));
		map.put(ItemType.RICE, new Item(ItemType.RICE.getName(),1,2,100));
	}
	public Item createItem(ItemType type){
		Item item = map.get(type).clone(); 
		return item;
	}

}
