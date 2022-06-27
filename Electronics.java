/*
* Electronics.java
* @author Maxwell Lyra - 20246943
* 23/03/2022
*/

public class Electronics{

	//Declaring variables
	private String itemName, itemColor;
	private int itemCode;
	private double itemPrice;


	public Electronics(){
	}

	// Hold values of object
	public Electronics (String itemName, double itemPrice, String itemColor, int itemCode){
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemColor =  itemColor;
		this.itemCode = itemCode;
	}


	// Getters and Setters
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}

	public void setitemColor(String itemColor){
		this.itemColor = itemColor;
	}

	public void setItemCode(int itemCode){
		this.itemCode = itemCode;
	}

	public String getItemName(){
		return itemName;
	}

	public double getItemPrice(){
		return itemPrice;
	}

	public String getItemColor(){
		return itemColor;
	}

	public int getItemCode(){
		return itemCode;
	}


}// class


