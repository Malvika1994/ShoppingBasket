package com.cognizant.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cognizant.vo.Basket;

public class CostCalculator {
	static Scanner sc = new Scanner(System.in);
	static List<Basket> list = new ArrayList<Basket>();
	static Map<String, Double> map = new HashMap<String, Double>();

	// Variable used inside addintoBasket()
	private static String choice = "yes";
	private static Double totalBill = 0.0D;
	private static Integer quantityOfFruits = 0;

	// final variables
	private static final String APPLE = "apple";
	private static final String BANANA = "banana";
	private static final String ORANGE = "orange";
	private static final String LEMON = "lemon";
	private static final String PEACH = "peach";
	private static final String YES = "yes";
	private static final String NO = "no";
	private static final String FRUIT_NAME_REGEX = "[A-Za-z]+";
	private static final String FRUIT_NAME_REGEX_VALID = "orange|banana|lemon|peach|apple";

	// Initialzing Fruits with Cost
	static {
		map.put(APPLE, 20.0D);
		map.put(BANANA, 10.0D);
		map.put(ORANGE, 15.0D);
		map.put(LEMON, 5.0D);
		map.put(PEACH, 7.0D);
	}

	public static Double addintoBasket() {

		// Enter the name of the fruit
		String fruitName = enterFruit();

		// Enter the Quantity of fruit
		conditionForQuantity();

		// Adding fruits in the basket
		Basket basket = new Basket(fruitName, quantityOfFruits);
		list.add(basket);

		System.out.println("Does you want to include more items");
		System.out.println("Enter yes/no");
		// yes or no
		choice = sc.nextLine();

		// Adding to the list or else displaying the bill
		conditionForYesNo(choice);
		return totalBill;
	}

	// Enter the fruit name
	public static String enterFruit() {
		System.out.println("Available fruits: apple, orange, peach, banana, lemon");
		String fruitName = (sc.nextLine()).toLowerCase().trim();

		// If the fruit name is not in the list or not valid fruit
		if (!(fruitName.matches(FRUIT_NAME_REGEX) && (fruitName.matches(FRUIT_NAME_REGEX_VALID)))) {
			System.out.println("Please enter only fruits that are available below");
			return enterFruit();
		}
		return fruitName;
	}

	// validating the quantity
	public static void conditionForQuantity() {
		System.out.println("Enter quantity");
		try {
			quantityOfFruits = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Quantity should be in dgits 0-9");
			conditionForQuantity();
		}
	}

	// Condition check method
	public static Double conditionForYesNo(String yesNo) {
		if (yesNo.equalsIgnoreCase(YES)) {
			return addintoBasket();
		} else if (yesNo.equalsIgnoreCase(NO)) {
			for (int i = 0; i < list.size(); i++) {
				String fruit = list.get(i).getFruitName();
				Double price = map.get(fruit);
				Integer fruitQuantity = list.get(i).getQuantity();
				totalBill = totalBill + (price * fruitQuantity);
			}
			System.out.println("Your bill is Rs: " + totalBill);
			return totalBill;
		} else {
			System.out.println("Wrong choice!, Enter yes or No");
			yesNo = sc.nextLine();
			conditionForYesNo(yesNo);
			return null;
		}
	}

	/*
	 * public static void main(String[] args) { System.out.println(
	 * "Add the items in the basket"); addintoBasket(); }
	 */

}
