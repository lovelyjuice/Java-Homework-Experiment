package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Student
{
    int No;
    String name;
    double chinese;
    double math;
    double english;
    double allScore;
    public Student() {}

    public Student(int no, String name, double chinese, double math, double english) 
    {
		No = no;
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.allScore = (chinese+math+english);
	}
	public void setMess(int No, String name, double chinese, double math, double english){
	
	}
    public double getAllScore() { return this.allScore; }
    public double aveScore() { return this.allScore/3; }
    public int getNo() { return this.No; }
    public String getName() { return this.name; }
}

 class Banji
{
    double number;  //总人数
    Student[] stu;
    public Banji(int size)
    {
        this.stu=new Student[size];
        this.number=size;
    }
    public void setStudent()
    {
      Scanner in=new Scanner(System.in);
      for(int i=0;i<number;i++)
      {
	      System.out.println("请输入No:");
	      stu[i].No=in.nextInt();
	      System.out.println("请输入name:");
	      stu[i].name=in.next();
	      System.out.println("请输入chinese score:");
	      stu[i].chinese=in.nextDouble();
	      System.out.println("请输入math score:");
	      stu[i].math=in.nextDouble();
	      System.out.println("请输入english score:");
	      stu[i].english=in.nextDouble();
      }
       
    }
    public Banji() { }
    public void ScoreMax()
    {
    	double englishBest = 0,mathBest=0,chineseBest=0;
    	for(int i=0;i<number;i++)if(englishBest<stu[i].english)englishBest=stu[i].english;
    	for(int i=0;i<number;i++)if(mathBest<stu[i].math)mathBest=stu[i].math;
    	for(int i=0;i<number;i++)if(chineseBest<stu[i].chinese)chineseBest=stu[i].chinese;
        System.out.println("Highest English score is "+englishBest);
        System.out.println("Highest Math score is "+mathBest);
        System.out.println("Highest Chinese score is "+chineseBest);
    }
    public void sortScore() //按总分降序排序
    {
       for(int i=0;i<number;i++)
       {
    	   for(int j=i+1;j<number;j++)
    	   {
    		   if(stu[i].allScore<stu[j].allScore)
    		   {
    			   Student temp=stu[i];stu[i]=stu[j];stu[j]=temp;
    		   }
    	   }
       }
        
    }

 	public void HighestThreeStu()
 	{
 		for(int i=0;i<3;i++)System.out.println("总分第"+(i+1)+"名："+stu[i].name);
 	}
}
    public class TestClass {
        static void main(String[] args)
        {
           
        }

    }


