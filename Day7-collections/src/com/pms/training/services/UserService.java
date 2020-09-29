package com.pms.training.services;

import java.util.ArrayList;
import com.pms.training.exceptions.BusinessException;


import com.pms.training.exceptions.UserNotFoundException;
import com.pms.training.pojos.User;

public interface UserService {
	public String login(String uname,String password)throws UserNotFoundException;
	public void signUp(User user)throws BusinessException;
	public ArrayList<User> getAllUsers()throws BusinessException;
//	public User getUserByIndex(int index);
	public void UpdateUser(User user,String newname,String passw) throws BusinessException;
	public void UpdateUserRole(User user,String newrole) throws BusinessException;
	public User getUserByName(String uname) throws UserNotFoundException;
}
