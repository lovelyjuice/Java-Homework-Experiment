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
		if(a>balance)System.out.println("Ǯ������Ŷ(��o��)");
		else balance-=a;
	}
	
	public boolean auth(String password)
	{
		if (this.passwd.equals(password))return true;
		return false;
	}
	
	public boolean changePasswd()
	{
		System.out.println("������ԭ����");
		Scanner in=new Scanner(System.in);
		String input=in.next();
		if(this.passwd.equals(input))
		{
			System.out.println("������������");
			this.passwd.replace(0,this.passwd.length(),in.next());
			System.out.println("������ĳɹ���");
			return true;
		}
		else System.out.println("ԭ�������");
		return false;
	}
	
	public static void main(String[] args) 
	{
		Bankmgr manager=new Bankmgr();
		Scanner in=new Scanner(System.in);
		while(true)
		{
			System.out.println("��ѡ�� 1.��¼    2.ע��");
			if(in.nextInt()==1)
			{
//				System.out.println("���¼��\n�û�����");
//				String username=in.next();
//				System.out.print("���룺");
//				String password=in.next();
				if(manager.login())
				{
					System.out.println("Login successfully!\n����������Ҫ�Ĳ����� 1.���   2.ȡ��   3.����");
					switch (in.nextInt())
					{
					case 1:System.out.print("�����:");manager.currentuser.deposit(in.nextDouble());break;
					case 2:System.out.print("ȡ����:");manager.currentuser.withdraw(in.nextDouble());break;
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

