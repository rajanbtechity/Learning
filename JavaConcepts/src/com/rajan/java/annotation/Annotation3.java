package com.rajan.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3{
	String str();
	int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Description{
	String desc();
}

@Description(desc="Class level Annotation")
@MyAnno3(str="Annotation3 class",val=10)
public class Annotation3 {

	@Description(desc="Method level Annotation")
	@MyAnno3(str="myMeth method",val=20)
	public static void myMeth()
	{
       Annotation3 a=new Annotation3();
		try{
			Class<?> c=a.getClass();
			Annotation annolist[]=c.getAnnotations();
			System.out.println("All Annotation of class Annotation3");
			for(Annotation anno:annolist)
			{
				System.out.print(anno);
			}
			System.out.println();
			Method m=c.getMethod("myMeth");
			annolist=m.getAnnotations();
			System.out.println(m.isAnnotationPresent(MyAnno3.class));
			System.out.println("All Annotation of method myMeth");
			
			for(Annotation anno:annolist){
				System.out.print(anno);
			}
			
		}catch(NoSuchMethodException exc){
			System.out.println("No Such method");
		}
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMeth();
	}

}
