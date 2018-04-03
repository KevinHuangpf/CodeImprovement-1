package com.kevinhuang.study;
import java.util.Scanner;

import org.w3c.dom.css.Counter;




public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("input a number(>=0):");
		@SuppressWarnings("resource")
		Scanner X = new Scanner(System.in);
		double x = X.nextDouble();
		String S = new String();
		S = "321";
		String y = Double.toString(x);
		double d = Double.parseDouble(S);
		
        
		int[] a= new int[10];
		
		for (int i = 0; i < 10; i++)
		a[i] = i * i;
		
		System.out.println(y);
		System.out.println(d);
		System.out.println("the sqrt is " + sqrt(x) );
	
        
		//Scanner X=new Scanner(System.in);
		//System.out.println("请输入一个>=1的整数(1不是素数，也不是合数)：");
		//int x=X.nextInt();
	}
	
	public static double sqrt(double n)
	{
		if(n<0) return Double.NaN;
		double err = 0.001;
		double t = n;

		while(Math.abs(t - n/t) > err )
		{
			t = (t + n/t)/2;
		}
		return t;
	}

}
