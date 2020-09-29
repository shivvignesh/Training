package com.pms.training.pojos;

import java.util.ArrayList;
import java.util.Comparator;


public class Catagory implements Comparable<Catagory>{
	
	private int catid;
	private String categoryName;
//	private ArrayList<Product> products = new ArrayList<Product>();
	
	public Catagory() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + catid;
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
		Catagory other = (Catagory) obj;
//		if (categoryName == null) {
//			if (other.categoryName != null)
//				return false;
//		} else if (!categoryName.equals(other.categoryName))
//			return false;
//		if (catid != other.catid)
//			return false;
//		return true;
		
		return this.getCategoryName().equalsIgnoreCase(other.getCategoryName()) && this.getCatid()==other.getCatid();
	}



	public Catagory(int catid, String categoryName) {
		this.catid = catid;
		this.categoryName = categoryName;
	}

	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
//	public ArrayList<Product> getProducts() {
//		return products;
//	}
//	public void setProducts(Product product) {
////		this.products = products;
//		products.add(product);
//	}
	
	@Override
	public String toString() {
		return "Catagory [catid=" + catid + ", categoryName=" + categoryName;
	}



	@Override
	public int compareTo(Catagory cat) {
		// TODO Auto-generated method stub
		return this.getCatid() - cat.getCatid(); 
	}
	
	
	
	
	
	

}
