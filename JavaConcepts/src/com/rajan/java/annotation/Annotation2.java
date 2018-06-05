package com.rajan.java.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/*
 * In Annotation1 program myMeth() has no parameter. Thus when getMethod() was called, only the name myMeth was passed.
 * However, to obtain a method that has parameters, you must specify class objects representing the types of those parameters as
 * arguments to getMethod.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2{
	String str();
	int val();
}

public class Annotation2 {

	@MyAnno2(str="Annotation string",val=100)
	public static void myMeth(String str,int i){
		System.out.println("myMeth() called "+str+" "+i);
		Annotation2 a=new Annotation2();
		
		try{
			Class<?> c=a.getClass();
			
			Method m=c.getMethod("myMeth", String.class,int.class);
			MyAnno2 myanno=m.getAnnotation(MyAnno2.class);
			System.out.println("Getting annotation values-"+myanno.str()+" "+myanno.val());
		}
		catch(NoSuchMethodException exc){
			System.out.print("No Such Method Exists");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMeth("String to myMeth",10);

	}

}
