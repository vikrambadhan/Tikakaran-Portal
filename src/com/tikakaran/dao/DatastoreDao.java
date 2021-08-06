package com.tikakaran.dao;

import static com.tikakaran.ofy.ObjectifyOfy.ofy;

import java.util.List;

import com.tikakaran.entity.UserEntity;

public class DatastoreDao 
{
	
	public static List<UserEntity> checkIfUserAlreadyExist(String uId)
	{
		List<UserEntity> li1 = ofy().load().type(UserEntity.class).filter("uId",uId ).list();
		
		return li1;
		}
	
	public static List<UserEntity> checkIfUserAlreadyExistbyLogin(String password)
	{
		List<UserEntity> li2 = ofy().load().type(UserEntity.class).filter("password",password ).list();
		
		return li2;
		}
	
	
	
	/*public static boolean saveData(String cName,String fName,String mName,String DOB,String mobile,String uId,String pass,String repass)
	{
		if(pass.equals(repass)==true)
		{
			
				
				List<UserEntity> det=load(uId,pass);
				if(SignupController.check(uId,pass,det)==true)
				{
					
					
					UserEntity user=new UserEntity(cName,fName,mName,DOB,mobile,uId,pass);
					ObjectifyOfy.ofy().save().entity(user);
					return true;
				}
				else if(SignupController.check(uId,pass,det)==false)
				{
					System.out.println("user id already available");
					return false; 
				}
		
			/*}
			else
			{
				return false;
			}*/
			
			
			/*System.out.println("00000");
			if(check(uId,pass)==true)
			{
				
				return true;
			}
			else 
				return false; 
			
		 }
		System.out.println("1234");
	return false;	
	}*/
	
	
	/*public static List<UserEntity> load(String uId,String pass)
	{
		//System.out.println("in check enter");
		List<UserEntity> det=ObjectifyOfy.ofy().load().type(com.tikakaran.entity.UserEntity.class).list();
	//	System.out.println("list is made");
		return det;
	}*/


	public static void saveUser(UserEntity user) {


		ofy().save().entity(user).now();
		
	}


	
}

