package com.sapient.w3.controller;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.sapient.w3.model.Post;
import com.sapient.w3.model.User;
import com.sapient.w3.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/v1/user")



public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/",produces= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	
	public List<User> listAll()
	{
		
		List<User> list=userService.fetchUsers();
    	//list.forEach(product->System.out.println(product.getName()));
    	
		return list;
    	
	}
	
	@PostMapping(value="/",consumes= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public User saveUser( @RequestBody User user)
	{
		User p=userService.saveUser(user);
		return p;
		
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") int id)
	{
		userService.deleteUser(id);
	}
	
	@PostMapping(value="/post/{id}",consumes= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public Post savePost(@RequestBody Post post,@PathVariable("id") int id)
	{
		Post p=userService.savePost(id,post);
		return p;
	}
	
@GetMapping(value="/post",produces= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	
	public List<Post> listPosts()
	{
		
		List<Post> list=userService.fetchPosts(1);
    	//list.forEach(product->System.out.println(product.getName()));
    	
		return list;
    	
	}

@DeleteMapping(value="/post/{idu}/{idp}")
public void deletePost(@PathVariable("idu") int idu,@PathVariable("idp") int idp)
{
	userService.deletePost(idu,idp);
}




@GetMapping(value="/{id}",produces= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.OK)

public  User findById(@PathVariable("id") int id)
{
	User p=userService.fetchById(id);		
	
	return p;
}

@GetMapping(value="/post/{id}",produces= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.OK)

public  Post fetchById(@PathVariable("id") int id)
{
	Post p=userService.findById(id);		
	
	return p;
}



@PutMapping(value="/post/{idu}/{idp}",consumes= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
public void updateProduct(@PathVariable("idu") int idu,@PathVariable("idp") int idp,@RequestBody Post post)
{
	Post p=userService.updatePost(idu, idp, post);
	
	
	
}



}

