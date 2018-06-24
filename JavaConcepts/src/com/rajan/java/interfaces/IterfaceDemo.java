package com.rajan.java.interfaces;

class IntfImplAllMethods implements OnlyMethods{

	@Override
	public double getRandomNum() {
		// TODO Auto-generated method stub
		System.out.println("Inside getRandomNum");
		return 0;
		
	}

	@Override
	public double getSquareRoot(double n) {
		// TODO Auto-generated method stub
		System.out.println("Inside getSquareRoot");
		return 0;
	}
	
	public void nonInterfaceMethod()
	{
		System.out.println("Inside nonInterfaceMethod");
	}
	
}


class IntfImplNonDefaultMethod implements OnlyMethodsWithDefault{

	@Override
	public int getVolume(int n, int m) {
		// TODO Auto-generated method stub
		System.out.println("Inside getVolume method");
		return 0;
	}

	
}

public class IterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntfImplAllMethods classObj1=new IntfImplAllMethods();
		/*
		 * Using class object we can access all the implemented methods as well non interface methods(obviously)
		 */
		System.out.println("Using Class object to access implemented methods as well as non interface methods");
		classObj1.getRandomNum();
		classObj1.getSquareRoot(10);
		classObj1.nonInterfaceMethod();
		
		System.out.println("Using Class object to access implemented methods and default method which is not implemented");
		IntfImplNonDefaultMethod classObj2=new IntfImplNonDefaultMethod();
		classObj2.getArea(1, 2);
		classObj2.getVolume(1, 2);
		
		System.out.println("Using Class object with interface refrence to access implemented methods only");
		OnlyMethods intf1=new IntfImplAllMethods();
		intf1.getRandomNum();
		intf1.getSquareRoot(10);
		/*
		 * non interface method not accessible using interface refrence variable
		 */
		//intf1.nonInterfaceMethod();
		


	}

}
