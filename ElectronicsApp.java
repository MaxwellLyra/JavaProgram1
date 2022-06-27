/*
* ElectronicsApp.java
* @author Maxwell Lyra - 20246943
* 23/03/2022
*/
import javax.swing.JOptionPane;

public class ElectronicsApp{
	public static void main (String args []){


	// Declaring and assigning values to variables
	int option, itemCode = 0; // variables for: option = prompt user for a choice in the main menu (between 1 and 6); itemCode = register a code for the eletronic
	String itemName, itemColor; // variables for: itemName: give a name to the eletronic to be registered and it's color
	double itemPrice = 0, sum, average = 0;// variables for: itemPrice = give a price to the eletronic registered; sum + average = calculate the average price of inventory
	final int MAX_NUM_ITEMS = 10; // * Required * constant as the maxinum number of items that can be stored in the application
	double searchPrice; // variable to be used for input on option 3 on the menu (indicating the price to be searched in the inventory)
	int j = 0; // variable created and inicializated in zero in order to iterate over the array of Eletronics and save the objects in different indexes

	// Variables to be used in option 5 = identify and hold values for item with highest price in the inventory
	double highestPrice;
	String highestName, highestColor;
	int highestCode;


	// Creating an array of Eletronics
	Electronics [] electro;

	// Instantiating this array
	electro = new Electronics [5];

	// Declaring an Eletronics object to be used as a  placeholder for the user's input
	Electronics e;

	// Input - Greetings to be displayed at the start of the application indicating the maxium number of items that can be added to the iventory
	JOptionPane.showMessageDialog(null, "Welcome to Electronics X!\nRegister up to 10 items in the Inventory");


	// do while loop with main menu to be axited ONLY if user press number "6"
	do {
		option = Integer.parseInt(JOptionPane.showInputDialog (null, "Application Menu - Item Type: Electronics\n1 - Add Item\n2 - Display all the items\n3 - Search and diplay\n4 - Calculate and display average\n5 - Item w/ highest price\n6 - Exit\n Please Enter your choice:"));


		switch (option){
			// Input - Add item - Eletronics
			case 1:
					if (j < MAX_NUM_ITEMS){
						itemName = JOptionPane.showInputDialog(null, "Please, enter a name");
						do { // VALIDATION of mandatory state "Price" with do while loop so that the user can only give a price between 100 and 5000
							itemPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Please, enter a price"));
								if (itemPrice < 100 || itemPrice > 5000){ //Message to inform user permited values to be entered
								JOptionPane.showMessageDialog(null, "Please, enter values between \u20ac 100 and \u20ac 5000");
								}
						} while (itemPrice < 100 || itemPrice > 5000);
						itemColor = JOptionPane.showInputDialog(null, "Please, enter a color");
						itemCode = Integer.parseInt(JOptionPane.showInputDialog(null, "Please, enter a registration code (ONLY numbers)"));


							// Instantiating the placeholder Eletronics object
							e = new Electronics (itemName, itemPrice, itemColor, itemCode);

							// insert this object into the array
							electro[j] = e;

							// progression / incrementing j
							j++;
					}

					else {
						JOptionPane.showMessageDialog(null, "The limit of items registered (10) has been achieved");
					}

				break;

			//Process and Outputs
			// Display items - Eletronics
			case 2:
				if (electro[0] == null){ // VALIDATION Informing user that there are no items registered in the inventory yet
					JOptionPane.showMessageDialog(null, "There are no items registered in the Inventory");
				}

				else {
					for (int i = 0; i < j; i++){
						JOptionPane.showMessageDialog(null, "Items details:" + "\nName: " + electro[i].getItemName() + "\nPrice: \u20ac " + electro[i].getItemPrice() + "\nColor: " +
						electro[i].getItemColor() + "\nCode: " + electro[i].getItemCode());
					}
				}

				break;

			// Search items (MANDATORY STATE - by Price)- Eletronics
			case 3:
				searchPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Search item by price:"));
				int k = 0; // variable initiate in 0 to be as a counter inside the for loops

					for (int i = 0; i < j; i++){ // loop to identify if there are any objects that meet this requirement
						if (electro[i].getItemPrice() == searchPrice){
							k++;
						}
					}

					if (k > 0){ // if the requirement was met then the program displays of all of those items
						for (int i = 0; i < j; i++) {
							if (electro[i].getItemPrice() == searchPrice){
								JOptionPane.showMessageDialog(null, "Name: " + electro[i].getItemName() + "\nPrice: \u20ac " + electro[i].getItemPrice() + "\nColor: " +
							electro[i].getItemColor() + "\nCode: " + electro[i].getItemCode());
							}
						}
					}

					else if (k == 0){ // if requirement wasn't met then this message is displayed
						JOptionPane.showMessageDialog(null, "There are no products registered with this price");
					}


				break;

			// Display avarage of price - Eletronics
			case 4:
				if (electro[0] == null){ // VALIDATION (extra feature) Informing user that there are no items registered in the inventory yet
					JOptionPane.showMessageDialog(null, "There are no items registered in the inventory");
					}

				else {
					sum = 0;

					for (int i = 0; i < j; i++){
					sum = sum + electro[i].getItemPrice();
					}

					average = sum / j;

					JOptionPane.showMessageDialog(null, "The average price of the items in the inventory is: \u20ac " + average);

				}

				break;

			// Display item(s) with highest price(s) (ASSIGNED FUNCTIONALITY) - ELetronics
			case 5:
				if (electro[0] == null){ // VALIDATION (extra feature) Informing user that there are no items registered in the inventory yet
					JOptionPane.showMessageDialog(null, "There are no items registered in the Inventory");
				}

				else {
					highestName = electro[0].getItemName();
					highestPrice = electro[0].getItemPrice();
					highestColor = electro[0].getItemColor();
					highestCode = electro[0].getItemCode();

					// for loop to compare each item in the array and hold the value of the last one that satisfy this condition
					for (int i = 1; i < j; i++){
						if (electro[i].getItemPrice() >= highestPrice){
							highestName = electro[i].getItemName();
							highestPrice = electro[i].getItemPrice();
							highestColor = electro[i].getItemColor();
							highestCode = electro[i].getItemCode();
						}
					}

					JOptionPane.showMessageDialog(null, "The item with highest price is: \nName: " + highestName + "\nPrice: " + highestPrice + "\nColor: " + highestColor + "\nCode: " + highestCode);
				}

				break;

			// EXIT
			case 6:
				JOptionPane.showMessageDialog(null, "Thank you for using the application, bye!");
				break;

			// Inform the user of valid input in case of entering numbers < 1 or > 6
			default:
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter an option between 1 and 6");
				break;

		} // switch

	} while (option != 6);


	} // main

} // class

