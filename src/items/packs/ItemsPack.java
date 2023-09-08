package items.packs;

import java.util.ArrayList;

import items.Item;

public class ItemsPack {

	
	private String name;
	private ArrayList<Item> packItems;
	private int maxCapacity;
	
	/**
	 * -1 - None Item
	 * 0  - All Item
	 * 1  - Armor
	 * 2  - tools
	 */
	private int type;
	
	public ItemsPack() {
		this.name = "Inventario";
		packItems = new ArrayList<Item>();
		maxCapacity = 27;
	}
	
	public void addItem(Item item) {
	
		for(int i = 0; i < packItems.size(); i++) {
			if(packItems.get(i).getId() == item.getId()) {
				boolean ifadd = packItems.get(i).plusItem();
				// terminar
			}
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
