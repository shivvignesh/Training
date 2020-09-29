package com.pms.training.pl;

import java.time.LocalDate;
import java.util.ArrayList;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TreeSet;


import com.pms.training.exceptions.BusinessException;
import com.pms.training.exceptions.UserNotFoundException;
import com.pms.training.pojos.User;
import com.pms.training.pojos.Product;
import com.pms.training.pojos.Catagory;
import com.pms.training.services.UserService;
import com.pms.training.services.ProductServiceImplementation;
import com.pms.training.services.UserServiceImpl;

public class ProductApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("How Many Users you want");
		UserService userService=new UserServiceImpl();
		ArrayList<Catagory> categories;
		System.out.println("How many product do you want to add");
		ProductServiceImplementation productService = new ProductServiceImplementation();
		
		do {
		System.out.println("1. Login \n 2. Signup \n 3. Exit");
		int choice=sc.nextInt();
		if(choice == 1) {
			
			System.out.println("Enter Username");
			String name=sc.next();
			System.out.println("Enter Password");
			String pass=sc.next();
			try {
			String role = userService.login(name, pass);
			System.out.println("Login Success");
			
			if(role.equalsIgnoreCase("Admin")) {
				boolean session = false;
				do {
				System.out.println("1. add products 2.Add category 3.Retrieve Products 4.Retrieve Categories 5.Filter by Categories 6.Exit");
				switch(sc.nextInt()) {
				case 1 : 
						System.out.println("Select the category");
					try {
						
						categories = productService.getAllCategories();
						
						
						int i=1;
						
						if(categories.isEmpty()) {
							System.out.println("Add categories first");
							break;
						}
						
						for(Catagory category:categories) {
							System.out.println((i++)+"."+category.getCategoryName());
						}
						int j = sc.nextInt();
						System.out.println("Enter 1.Pid 2.Pname 3.Cost 4.Quantity 5.Brand");
						Product prod = new Product(sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextInt(),sc.next(),categories.get(j-1));
//						categories.get(j-1).setProducts(prod);
						try {
							productService.addProduct(prod);
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
//							e.printStackTrace();
						}
						catch(NullPointerException e) {
							System.out.println(e.getMessage());
							
						}
						
						}
					 catch (BusinessException e2) {
						// TODO Auto-generated catch block
						System.out.println(e2.getMessage());
					}
						 
					
						 break;
						 
				case 2 : 
						System.out.println("Enter 1.CategoryId 2.Category Name");
						Catagory cat = new Catagory(sc.nextInt(),sc.next());
						
					try {
						productService.addCategory(cat);
					} catch (BusinessException e1) {
						// TODO Auto-generated catch block
//						e1.printStackTrace();
						System.out.println(e1.getMessage());
					}
						break;
						 
				case 3 : 
						System.out.println("The products are ");
						try {
							TreeSet<Product> products = productService.getAllProducts();
						for(Product product:products) {
							System.out.println(product);
						}
						}
						catch(BusinessException e) {
							System.out.println(e.getMessage());
						}
						break;
				case 4 : 
						System.out.println("The categories are ");
						try {
							categories = productService.getAllCategories();
							for(Catagory category:categories)
								System.out.println(category);
						}
						catch(BusinessException e) {
							System.out.println(e.getMessage());
						}
						break;
				
//				case 5 : System.out.println("The available categories");
//					try {
//						categories = productService.getAllCategories();
//						int i = 1;
//						for(Catagory category : categories) {
//							System.out.println((i++)+"."+category.getCategoryName());
//							
//						}
//						
//						try {
//						int j = sc.nextInt();
//						Catagory category = categories.get(j-1);
////						ArrayList<Product> products = productService.getAllProductsByCategory(category);
//						for(Product product : products) {
//							System.out.println(product);
//						}
//						} catch(BusinessException e) {
//							System.out.println(e.getLocalizedMessage());
//						}
//						
//					} catch (BusinessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					break;
				
				case 6 : session = true;
						break;
				
				default : System.out.println("Invalid choice, choose again");
						  break;
					
				}
			}while(session!=true);
			
			}
			
			
			if (role.equalsIgnoreCase("User")) {
//				System.out.println("For Which Index");
//				int i=sc.nextInt();
//				User newUser=userService.getUserByIndex(i);
				User newUser = userService.getUserByName(name);
				System.out.println("1. Update UserName & Password 2. Update Role");
//				newUser.setUname(sc.next());
//				newUser.setPassword(sc.next());
//				newUser.setRole(sc.next());
				
				switch(sc.nextInt()) {
				case 1 : System.out.println("Enter username");
						 String uname = sc.next();
						 System.out.println("Enter password");
						 String passw = sc.next();
						 
						 try {
							 userService.UpdateUser(newUser, uname, passw);
						 }
						 catch (BusinessException e) {
							 System.out.println(e.getMessage());
						 }
						 break;
						 
				case 2 : System.out.println("Enter role");
						 String newrole = sc.next();
						 try {
							 userService.UpdateUserRole(newUser, newrole);
						 }
						 catch (BusinessException e) {
							 System.out.println(e.getMessage());
						 }
				}
				
				System.out.println("User Updated");
				
				try {
					ArrayList<User> users = userService.getAllUsers();
					for(User u:users) {
						System.out.println(u);
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			}
			
			catch(UserNotFoundException u) {
				System.out.println(u.getMessage());
				 
			}
			
			
		
		}
		
		else if(choice == 2){
			System.out.println("Enter the User Details 1. Dob, 2. Username 3.Password 4.Role 5.ContactNumber");
			String someDate =sc.next();
			DateTimeFormatter sd12=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			LocalDate dob=LocalDate.parse(someDate,sd12);
			User user=new User(sc.next(), sc.next(), sc.next(), dob, sc.nextLong());
			try {
				userService.signUp(user);
				ArrayList<User> users=userService.getAllUsers();
				for(User u:users) {
					System.out.println(u);
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(choice ==3) {
			System.out.println("Thank You");
			sc.close();
			System.exit(0);
		}
		else {
			System.out.println("invalid");
		}
		
		}while(true);

	}

}
