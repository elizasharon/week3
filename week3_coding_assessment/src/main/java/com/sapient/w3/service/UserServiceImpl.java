package com.sapient.w3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sapient.w3.dao.UserDAO;
import com.sapient.w3.model.Address;
import com.sapient.w3.model.Post;
import com.sapient.w3.model.User;


@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired( required = true)
    @Qualifier(value = "hibernateDAOImpl")
	private UserDAO userDAO;
	
	public UserServiceImpl(@Qualifier(value = "hibernateDAOImpl")UserDAO userDAO)
			{
					this.userDAO=userDAO;
			}
			
	@Transactional
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.saveUser(user);
		
	}

	@Transactional
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	 userDAO.deleteUser(id);

	}

	@Transactional
	public List<User> fetchUsers() {
		// TODO Auto-generated method stub
		return userDAO.fetchUsers();
	}

	@Transactional
	public Post savePost(int u_id,Post post) {
		// TODO Auto-generated method stub
		return userDAO.savePost(u_id,post);
	}

	@Transactional
	public void deletePost(int u_id, int p_id) {
		// TODO Auto-generated method stub
		userDAO.deletePost(u_id, p_id);

	}

	@Transactional
	public Post updatePost(int u_id, int p_id, Post post) {
		// TODO Auto-generated method stub
		return userDAO.updatePost(u_id, p_id, post);
	}

	@Transactional
	public List<Post> fetchPosts(int u_id) {
		// TODO Auto-generated method stub
		return userDAO.fetchPosts(u_id);
	}


	@Transactional
	public User fetchById(int id) {
		// TODO Auto-generated method stub
		return userDAO.fetchById(id);
	}
	
	@Transactional
	public Post findById(int id)
	{
		return userDAO.findById(id);
	}

}
