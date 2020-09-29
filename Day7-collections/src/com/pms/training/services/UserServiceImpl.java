package com.pms.training.services;

import java.util.ArrayList;

import com.pms.training.exceptions.BusinessException;

import com.pms.training.exceptions.UserNotFoundException;
import com.pms.training.pojos.User;

public class UserServiceImpl implements UserService {
	
	ArrayList<User> users = new ArrayList<User>();
	
	@Override
	public String login(String uname, String password) throws UserNotFoundException {
		boolean status=false;
//		User usr;
		for(User user:users) {
			if(user.getUname().equals(uname) && user.getPassword().equals(password)) {
				status=true;
			
				return user.getRole();
				
			}	
		}
		if(!status)
				throw new UserNotFoundException("User Not exist");
		return "user not found";	
	}

	@Override
	public void signUp(User user) throws BusinessException {

			if(user.getUname().matches("[A-Z][A-Za-z]*")) {
				if(user.getPassword().matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{1,8}")) {
					if(user.getRole().equalsIgnoreCase("user") || user.getRole().equalsIgnoreCase("admin")) {
						users.add(user);
						
					}else {
					  throw new BusinessException("Invalid Role");	
					}
				}else {
					throw new BusinessException("Invalid Password(Combination of upper , lower and number with 8 charecters)");
				}
			}else {
				throw new BusinessException("Invalid Username");
			}
		

	}

	@Override
	public ArrayList<User> getAllUsers() throws BusinessException {
		return users;
	}

//	@Override
////	public User getUserByIndex(int index) {
//		// TODO Auto-generated method stub
//		return users[index];
//		
//	}

	@Override
	public void UpdateUser(User user,String newname,String passw) throws BusinessException{
		// TODO Auto-generated method stub
		if(newname.matches("[A-Z][A-Za-z]*")) {
			if(passw.matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{1,8}")) {
				user.setUname(newname);
				user.setPassword(passw);
			
			}
			else {
				throw new BusinessException("Invalid Password format");
			}
			
		}
		else {
				throw new BusinessException("Invalid Username format");
		}
		
	}
	
	public void UpdateUserRole(User user,String newrole) throws BusinessException{
		if(newrole.equalsIgnoreCase("Admin")||newrole.equalsIgnoreCase("User")) {
			user.setRole(newrole);
		}
		else {
			throw new BusinessException("Invalid Role");
		}
	}

	@Override
	public User getUserByName(String uname) throws UserNotFoundException {
		// TODO Auto-generated method stub
		boolean status = false;
		for(User user:users) {
			if(user.getUname().equals(uname)) {
				status = true;
				return user;
			}
		}
		if(!status) {
		throw new UserNotFoundException("User not found");
	}
		return null;
	
	

}
}
