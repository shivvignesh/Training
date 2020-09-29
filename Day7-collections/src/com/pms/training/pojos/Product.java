package com.pms.training.pojos;

public class Product implements Comparable<Product>{
	
	private int pid;
	private String pname;
	private double cost;
	private int qty;
	private String brand;
	private Catagory category;
	
	
	
	public Product() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
//		result = prime * result + ((category == null) ? 0 : category.hashCode());
		long temp;
//		temp = Double.doubleToLongBits(cost);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pid;
//		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
//		result = prime * result + qty;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Product other = (Product) obj;
//		if (brand == null) {
//			if (other.brand != null)
//				return false;
//		} else if (!brand.equals(other.brand))
//			return false;
//		if (category == null) {
//			if (other.category != null)
//				return false;
//		} else if (!category.equals(other.category))
//			return false;
//		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
//			return false;
//		if (pid != other.pid)
//			return false;
//		if (pname == null) {
//			if (other.pname != null)
//				return false;
//		} else if (!pname.equals(other.pname))
//			return false;
//		if (qty != other.qty)
//			return false;
//		return true;
		
		return this.getPid() == other.getPid();
		
	}



	public Product(int pid, String pname, double cost, int qty, String brand) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.qty = qty;
		this.brand = brand;
		this.category = new Catagory();
	}
	public Product(int pid, String pname, double cost, int qty, String brand, Catagory cat) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.qty = qty;
		this.brand = brand;
		this.category = cat;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Catagory getCategory() {
		return category;
	}
	public void setCategory(Catagory category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", qty=" + qty + ", brand=" + brand
				+ ", category=" + category + "]";
	}

	@Override
	public int compareTo(Product product) {
		// TODO Auto-generated method stub
		return this.getPid() - product.getPid();
	}
	
}
