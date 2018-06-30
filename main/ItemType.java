/**
 * 
 */
package main;

/**商品の種類を表す定数
 * @author misskabu
 *
 */
public enum ItemType {
	BAKERY("パン"),RICE("米飯");
	private final String name;
	
	
	private ItemType(final String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
