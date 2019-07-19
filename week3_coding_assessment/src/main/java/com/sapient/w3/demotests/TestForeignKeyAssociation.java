package com.sapient.w3.demotests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sapient.w3.model.Address;
import com.sapient.w3.model.User;

public class TestForeignKeyAssociation {
	 
    public static void main(String[] args) {
    	SessionFactory sessionFactory = null;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
 
        User user = new User();
        user.setName("madhvi");
 
        // Add new Employee object
        Address add = new Address();
        add.setCity("gkhf");
        add.setState("djf");
        add.setPincode(4522);
        

        // Save Account
        session.saveOrUpdate(user);
        // Save Employee
       add.setUser(user);
        session.saveOrUpdate(add);
 
        session.getTransaction().commit();
        
    }
}