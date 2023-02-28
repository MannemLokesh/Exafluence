package com.exfscm.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.ModelAndView;

import com.exfscm.model.UserModel;
import com.exfscm.service.AuthService;

@Controller
public class AuthController 
{
	private static String userName;
	
	public static void setUserName(String userName)
	{
		AuthController.userName=userName;
	}
	
	@Autowired
	private AuthService service;

	// This method will return Home Page (Sign Up Page)
	@GetMapping("/")
	public ModelAndView homePage() throws FileNotFoundException, InternalServerError
	{
		ModelAndView modelAndView=null;
		try
		{
			if(modelAndView==null)
			{
				modelAndView= new ModelAndView();
				modelAndView.setViewName("signup");
			}	
		}
		catch(Exception e)
		{
			modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
		return modelAndView;
	}

	// This method will post the User Registration Data in DB
	@PostMapping("/signup")
	public ModelAndView signUpPage(UserModel userModel) throws FileNotFoundException, InternalServerError
	{
		ModelAndView modelAndView = null;
		
		try
		{
			if(modelAndView==null)
			{
				modelAndView=new ModelAndView();
			}
			
			String message = service.save(userModel);
	
			// If Registration is successful, It will redirect to login Page with a message
			if (message.equals("Registration Successful"))
			{
				modelAndView.setViewName("login");
				modelAndView.addObject("message", userModel.getUserName() + " Your " + message + ", Please login!");
				return modelAndView;
			} 
			else // If Any User Exist with the Email, It will redirect to sign up Page with a message
			{
				modelAndView.addObject("message", userModel.getEmail() + " is " + message);
				modelAndView.setViewName("signup");
				return modelAndView;
			}
		}
		catch(Exception e)
		{
			modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}

	//This method will check the Credentials of User
	@PostMapping("/login")
	public ModelAndView isValidUser(UserModel userModel) throws FileNotFoundException, InternalServerError
	{
		ModelAndView modelAndView = null;
		
		try
		{
			if(modelAndView==null)
			{
				modelAndView = new ModelAndView();
			}
			
			String message=service.login(userModel);
			
			//If the Credentials are valid, It will redirect to Dash board Page
			if(message.equals("login success"))
			{
				modelAndView.setViewName("dashboard");
				modelAndView.addObject("name", userName);
				return modelAndView;
			}
			//If the User Name is Not Exist in the DB, It will redirect to login Page with a message
			else if(message.equals("Username not valid!"))
			{
				modelAndView.setViewName("login");
				modelAndView.addObject("message", message);
				return modelAndView;
			}
			//If the Password is incorrect, It will redirect to login Page with a message
			else
			{
				modelAndView.setViewName("login");
				modelAndView.addObject("message", message);
				return modelAndView;
			}
		}
		catch(Exception e)
		{
			modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}
	
	//This method is used to redirect to createShipment Page
	@GetMapping("/shipment")
	public ModelAndView shipment() throws FileNotFoundException, InternalServerError
	{
		ModelAndView modelAndView = null;
		
		try
		{
			if(modelAndView==null)
			{
				modelAndView = new ModelAndView();
			}
			modelAndView.setViewName("createshipment");
			return modelAndView;
		}
		catch(Exception e)
		{
			modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}
	
	
	//This method is used to redirect to createShipment Page
	@GetMapping("/dashboard")
	public ModelAndView dashboard() throws FileNotFoundException, InternalServerError
	{
		ModelAndView modelAndView = null;
		
		try
		{
			if(modelAndView==null)
			{
				modelAndView = new ModelAndView();
			}
			modelAndView.setViewName("dashboard");
			return modelAndView;
		}
		catch(Exception e)
		{
			modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}

	// postman testing
	// --------------------------------------
	/*
	 * @Autowired private AuthRepository repository;
	 * 
	 * @PostMapping("/") public ResponseEntity<AuthUserModel>
	 * saveAuthUser(@RequestBody AuthUserModel userModel) { Optional<AuthUserModel>
	 * authusermodel=repository.findById(userModel.getEmail());
	 * if(authusermodel.isPresent()) { return new
	 * ResponseEntity<>(HttpStatus.FOUND); } else { return new
	 * ResponseEntity<>(repository.save(userModel),HttpStatus.CREATED); } }
	 * 
	 * @PostMapping("login/{email}/{password}") public
	 * ResponseEntity<List<AuthUserModel>> validateAuthUser(@PathVariable String
	 * email, @PathVariable String password) { Optional<AuthUserModel>
	 * authlogin=repository.findById(email); if(authlogin.isPresent()) { return new
	 * ResponseEntity<>(HttpStatus.FOUND); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
}
