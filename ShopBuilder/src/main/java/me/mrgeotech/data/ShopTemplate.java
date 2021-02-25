package me.mrgeotech.data;

public class ShopTemplate {
	
	private String name;
	private int cost;
	private String schemeName;
	
	public ShopTemplate(String name, int cost, String schemeName) {
		this.name = name;
		this.cost = cost;
		this.schemeName = schemeName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	
}
