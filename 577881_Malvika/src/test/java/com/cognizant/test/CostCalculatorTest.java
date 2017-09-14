package com.cognizant.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import com.cognizant.client.CostCalculator;
import com.cognizant.vo.Basket;

public class CostCalculatorTest {

	CostCalculator cc = new CostCalculator();

	Basket basket;

	@Test
	public void testForBasket() {
		String fruitName = "apple";
		Integer quantity = 1;
		basket = new Basket(fruitName, quantity);
		Assert.assertTrue(basket.getFruitName().equals(fruitName));
		Assert.assertTrue(basket.getQuantity() == quantity);
	}

	@Test
	public void testForSetter() {
		String fruitName = "apple";
		Integer quantity = 1;
		basket = new Basket();
		basket.setFruitName(fruitName);
		basket.setQuantity(quantity);
		Assert.assertTrue(basket.getFruitName().equals(fruitName));
		Assert.assertTrue(basket.getQuantity() == quantity);

	}

	@Test
	public void test() {
		Double total = CostCalculator.addintoBasket();
		assertFalse(total == null);
	}

	@Test
	public void testEquals() {
		Basket basket1 = new Basket("apple", 1);
		Basket basket2 = new Basket("apple", 1);
		assertTrue(basket1.equals(basket2));

	}

	@Test
	public void testHashCode() {
		Basket basket1 = new Basket("apple", 1);
		Basket basket2 = new Basket("apple", 1);
		assertTrue(basket1.hashCode() == basket2.hashCode());

	}

	@Test
	public void testToString() {
		Basket basket1 = new Basket("apple", 1);
		Basket basket2 = new Basket("apple", 1);
		assertTrue(basket1.toString().equals(basket2.toString()));

	}

}
