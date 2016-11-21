package homework;
import java.util.Scanner;
public class Array {

public Array(int[]a)
	{
		for(int i=0;i<this.a.length;i++)
		{
			this.a[i]=a[i];
		}
	}
	int[] a=new int[10];
	private void order()
	{
		int i,j,temp;
		for(i=0;i<this.a.length;i++)
		{
			for(j=i+1;j<this.a.length;j++)
			{
				if(this.a[i]>this.a[j])
				{temp=this.a[i];this.a[i]=this.a[j];this.a[j]=temp;}
			}
		}
		for(int b:this.a)
		{
		System.out.print(b+" ");
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int[] array=new int[10];
		for(int a=0;a<array.length;a++)
		{
			array[a]=in.nextInt();
		}
		Array one=new Array(array);
		one.order();
	}

}
