package com.cognizant.vo;

public class Basket {
	String fruitName;
	Integer quantity;

	public Basket() {
	}

	public Basket(String fruitName, Integer quantity) {
		super();
		this.fruitName = fruitName;
		this.quantity = quantity;

	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fruitName == null) ? 0 : fruitName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Basket other = (Basket) obj;
		if (fruitName == null) {
			if (other.fruitName != null)
				return false;
		} else if (!fruitName.equals(other.fruitName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Basket [fruitName=" + fruitName + ", quantity=" + quantity + "]";
	}

}
