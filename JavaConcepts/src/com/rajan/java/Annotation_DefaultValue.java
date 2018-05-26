package com.rajan.java;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno4{
	String str() default "default_string";
	int val() default 100;
}

public class Annotation_DefaultValue {
	
	@MyAnno4
	public static void myMeth(String str,int i)
	{
		Annotation_DefaultValue a=new Annotation_DefaultValue();
		try {
			Class<?> c=a.getClass();
			Method m=c.getMethod("myMeth", String.class,int.class);
			MyAnno4 myanno=m.getAnnotation(MyAnno4.class);
			System.out.println(myanno.str()+" "+myanno.val());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMeth("String param",10);

	}

}
