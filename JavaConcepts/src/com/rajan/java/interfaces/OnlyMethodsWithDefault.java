package com.rajan.java.interfaces;

public interface OnlyMethodsWithDefault {
default public int getArea(int n,int m)
{
	System.out.println("Inside getArea default method of OnlyMethodsWithDefault interface");
	return n*m;
}

public int getVolume(int n,int m);
}
