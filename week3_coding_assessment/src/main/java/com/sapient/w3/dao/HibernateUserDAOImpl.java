package com.sapient.w3.dao;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sapient.w3.model.Address;
import com.sapient.w3.model.Post;
import com.sapient.w3.model.User;

@Repository("hibernateDAOImpl")

public class HibernateUserDAOImpl implements UserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		//session.save(add);
        session.save(user);
        return user;
		
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);
		

	}

	public List<User> fetchUsers() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User ").list();
		
		
	}
	
	public User fetchById(int id)
	{
		
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	public Post savePost(int u_id,Post post) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		User usr=session.get(User.class, u_id);
		List<Post> list=usr.getPost();
		list.add(post);
		usr.setPost(list);
		session.save(usr);
		
		return post;
	}

	public void deletePost(int u_id, int p_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User usr=session.get(User.class, u_id);
		Post post=session.get(Post.class, p_id);
		List<Post> list=usr.getPost();
		session.delete(post);
		 int i;
		 Post p;
		 
		 
		 for(i=0;i<list.size();i++)
		 {
			 p=list.get(i);
			 if(p.getId()==p_id)
			 {
				 list.remove(i);
			 }
		 }
	        
	        usr.setPost(list);
		session.saveOrUpdate(usr);

	}

	public Post updatePost(int u_id, int p_id, Post post) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Post p=sessionFactory.getCurrentSession().get(Post.class, p_id);
		p.setBody(post.getBody());
		p.setTitle(post.getTitle());
		p.setId(p_id);
		session.saveOrUpdate(p);
		return p;
		
	}

	public List<Post> fetchPosts(int u_id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Post ").list();
		
		
	}
	
	public Post findById(int id)
	{
		return sessionFactory.getCurrentSession().get(Post.class, id);
	}
	
	

}
