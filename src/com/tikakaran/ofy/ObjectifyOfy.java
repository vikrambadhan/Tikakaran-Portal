package com.tikakaran.ofy;


import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.tikakaran.entity.UserEntity;


public class ObjectifyOfy
{
    //Loading Entity Classes
	static {
        factory().register(UserEntity.class);
		//factory().register(anothercompleteclassnamewith package.class);
        
    }
	
	//Return Objectify
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    //Register Factory
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}