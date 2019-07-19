package com.sapient.w3.dao;

import java.util.List;

import com.sapient.w3.model.Address;
import com.sapient.w3.model.Post;
import com.sapient.w3.model.User;

public interface UserDAO {
	
	public User saveUser(User user);
	public void deleteUser(int id);
	public List<User> fetchUsers();
	public Post savePost(int u_id,Post post);
	public void deletePost(int u_id,int p_id);
	public Post updatePost(int u_id,int p_id,Post post);
	public List<Post> fetchPosts(int u_id);
	public User fetchById(int id);
	public Post findById(int id);
	
	
	
	

}
