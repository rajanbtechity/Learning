package com.rajan.java.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/*
 *Program to define an annotation and associate it with a method and try to get the 
 *details of the annotation associated with the method. Method has no parameter 
 */


//An annotation declaration
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str();
	int price();
}

public class Annotation1 {
    //Annotate a method
	@MyAnno(str="Test String",price=100)
	public static void myMeth()
	{
		Annotation1 a=new Annotation1();
		
		
		//Obtain the annotation for this method and
		//display the values of the members.
		try{
			//First get a class object which represent this class
			Class<?> c=a.getClass();
			
			//Now get a method object that represents this method
			Method m=c.getMethod("myMeth");
			
			//Now get the annotation of this class
			MyAnno myanno=m.getAnnotation(MyAnno.class);
			
			//Finally display the output
			System.out.println(myanno.str()+" "+myanno.price());
		}
		catch(NoSuchMethodException exc){
			System.out.println("No Such Method Found");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMeth();

	}

}
