package com.pms.training.services;

import com.pms.training.exceptions.BusinessException;

import java.util.ArrayList;
import java.util.TreeSet;

import com.pms.training.pojos.Catagory;
import com.pms.training.pojos.Product;

public class ProductServiceImplementation implements ProductService {
	
//	private ArrayList<Product> products = new ArrayList<Product>();
	private TreeSet<Product> products = new TreeSet<Product>();
	private ArrayList<Catagory> categories = new ArrayList<Catagory>();
	private ArrayList<Product> productbycat = new ArrayList<Product>();
	
	@Override
	public Product getProduct(int index) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Product> getAllProducts() throws BusinessException {
		// TODO Auto-generated method stub
		
		if(products.isEmpty())
			throw new BusinessException("No available products");
		return products;
	}

	@Override
	public ArrayList<Catagory> getAllCategories() throws BusinessException {
		// TODO Auto-generated method stub
		
		if(categories.isEmpty())
			throw new BusinessException("No categories, Add them");
		
		return categories;
	}

	@Override
	public void addProduct(Product p) throws BusinessException {
		// TODO Auto-generated method stub
		boolean exists = false;
		if(products.isEmpty()) {
			System.out.println("Empty");
			products.add(p);
		}
		else {
//		for(Product product:products) {
//			if(product.getPid()==p.getPid()) {
//				exists = true;
//				throw new BusinessException("Product id exists");
//				
//			}
//		}
//		
//		if(!exists) {
//		products.add(p);
//			}
			System.out.println("Not Empty");	
		products.add(p);
		}
	}
		
	@Override
	public void addCategory(Catagory c) throws BusinessException {
		// TODO Auto-generated method stub
		boolean exists = false;
		
		if(categories.isEmpty()) {
			categories.add(c);
		}
		
		else {
//			for(Catagory category : categories) {
//				if((category.getCatid()==c.getCatid()) | (category.getCategoryName().equalsIgnoreCase(c.getCategoryName()))) {
//					throw new BusinessException("Category exists");
//				}
//			}
//		
//		
//		if(!exists) {
//			categories.add(c);
//		}
		categories.add(c);
		}

	}
}

//	@Override
//	public ArrayList<Product> getAllProductsByCategory(Catagory cat) throws BusinessException {
//		// TODO Auto-generated method stub
////		ArrayList<Product> productbycat = new ArrayList<Product>();
////		for(Product product : products) {
////			if((product.getCategory()).getCategoryName().equals(cat.getCategoryName())) {
////				productbycat.add(product);
////			}
////		}
////		
////		if(productbycat.isEmpty()) {
////			throw new BusinessException("No products in that category available");
////		}
////		
////		return productbycat;
////	}
//		
//		productbycat = cat.getProducts();
//		
//		if(productbycat.isEmpty()) {
//			throw new BusinessException("No Products");
//		}
//		
//		return productbycat;
//	}

