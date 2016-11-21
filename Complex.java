package homework;

import java.util.Scanner;
public class Complex
{
	public static void main(String[] args)
	{
		Complex num1=new Complex();
		Complex num2=new Complex();
		int a;
		Scanner in=new Scanner(System.in);
		System.out.print("请输入第一个复数a+bi\na=");
		num1.real=in.nextDouble();
		System.out.print("b=");
		num1.imag=in.nextDouble();
		System.out.println("请告诉我你想干什么：\n1.加  2.减  3.乘\n");
		a=in.nextInt();
		System.out.print("请输入第二个复数a+bi\na=");
		num2.real=in.nextDouble();
		System.out.print("b=");
		num2.imag=in.nextDouble();
		switch (a)
		{
		case 1:System.out.println(num1.plus(num2));break;
		case 2:System.out.println(num1.minus(num2));break;
		case 3:System.out.println(num1.multiply(num2));break;
		}
		
	}
	
	private double real,imag;
	
	public Complex(){}
	
	public Complex(double real,double imag)
	{
		this.real=real;this.imag=imag;
	}
	
	public String toString()
	{
		if(imag==0)return real+"";
		else if(real==0)return imag+"i";
		else if(imag>0)return real+"+"+imag+"i";
		return real+""+imag+"i";
	}
	
	private Complex plus(Complex b)
	{
		Complex c=new Complex();
		c.real=this.real+b.real;
		c.imag=this.imag+b.imag;
		return c;
	}
	
	private Complex minus(Complex b)
	{
		Complex c=new Complex();
		c.real=this.real-b.real;
		c.imag=this.imag-b.imag;
		return c;
	}
	
	private Complex multiply(Complex b)
	{
		Complex c=new Complex();
		c.real=this.real*b.real-this.imag*b.imag;
		c.imag=this.real*b.imag+this.imag*b.real;
		return c;
	}
	
}