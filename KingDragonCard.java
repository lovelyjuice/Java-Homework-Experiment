package homework;
import java.util.ArrayList;
import java.util.Scanner;

public class KingDragonCard {

	private int id;
	private static int autoincrease=1;
	public StringBuffer name=new StringBuffer();
	private StringBuffer passwd=new StringBuffer();
	private double balance;
	
	KingDragonCard(StringBuffer name,StringBuffer passwd)
	{
		this.id=autoincrease++;
		this.name.append(name);
		this.passwd.append(passwd);
	}

	public double deposit(double a)
	{
		this.balance+=a;
		return balance;
	}
	
	public void withdraw(double a)
	{
		if(a>balance)System.out.println("钱不够了哦(⊙o⊙)");
		else balance-=a;
	}
	
	public boolean auth(String password)
	{
		if (this.passwd.equals(password))return true;
		return false;
	}
	
	public boolean changePasswd()
	{
		System.out.println("请输入原密码");
		Scanner in=new Scanner(System.in);
		String input=in.next();
		if(this.passwd.equals(input))
		{
			System.out.println("请输入新密码");
			this.passwd.replace(0,this.passwd.length(),in.next());
			System.out.println("密码更改成功！");
			return true;
		}
		else System.out.println("原密码错误！");
		return false;
	}
	
	public static void main(String[] args) 
	{
		Bankmgr manager=new Bankmgr();
		Scanner in=new Scanner(System.in);
		while(true)
		{
			System.out.println("请选择 1.登录    2.注册");
			if(in.nextInt()==1)
			{
//				System.out.println("请登录：\n用户名：");
//				String username=in.next();
//				System.out.print("密码：");
//				String password=in.next();
				if(manager.login())
				{
					System.out.println("Login successfully!\n请输入你需要的操作： 1.存款   2.取款   3.改密");
					switch (in.nextInt())
					{
					case 1:System.out.print("存款金额:");manager.currentuser.deposit(in.nextDouble());break;
					case 2:System.out.print("取款金额:");manager.currentuser.withdraw(in.nextDouble());break;
					case 3:manager.currentuser.changePasswd();
					}
				}
				
			}

		}
	}

}

class Bankmgr
{
	Scanner in=new Scanner(System.in);
	ArrayList<KingDragonCard> list=new ArrayList<KingDragonCard>();
	KingDragonCard currentuser;
	
	boolean login()
	{
		System.out.print("input username:");
		String username=in.next();
		System.out.print("input password:");
		String password=in.next();
		boolean auth=false;
		for(int i=0;i<list.size();i++)
		{
			currentuser=list.get(i);
			if (currentuser.name.equals(username)&&currentuser.auth(password))auth=true;
		}	
		return auth;
	}
}

