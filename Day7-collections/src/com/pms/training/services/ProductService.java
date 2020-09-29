package com.pms.training.services;

import java.util.ArrayList;
import java.util.TreeSet;

import com.pms.training.exceptions.BusinessException;

import com.pms.training.pojos.Catagory;
import com.pms.training.pojos.Product;

public interface ProductService {
	public Product getProduct(int index)throws BusinessException;
	public TreeSet<Product> getAllProducts()throws BusinessException;
	public ArrayList<Catagory> getAllCategories()throws BusinessException;
	public void addProduct(Product p)throws BusinessException;
	public void addCategory(Catagory c)throws BusinessException;
//	public ArrayList<Product> getAllProductsByCategory(Catagory cat)throws BusinessException;
}

