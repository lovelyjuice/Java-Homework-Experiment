package homework;
import java.util.Scanner;
class  Teacher
{
   private int id;
   private String key;
   private String name;
   public String title[]=new String[10]; //题目
   public String answer[]=new String[10];//答案
  

   private static int TeacherNumber=0;  //教师总人数

   public Teacher(){ TeacherNumber++; }
   public Teacher(int id,String key,String name,String title[],String answer[],int grade[],int score){ 
    this.id=id;  this.name=name; this.key=key; 
    this.title=title; this.answer=answer; 
  
    TeacherNumber++;
   }
   public void setBaseMessage(int id,String key,String name)
   {    this.id=id;  this.name=name; this.key=key;   }
   public int getId()  {  return id; }
   public String getName()  {  return name; }
   public String getKey()  {  return key; }
   public void setTitle(String title[]) { this.title=title; }
   public void setAnswer(String answer[]) { this.answer=answer; }
  
   public void getTitle() {
      for(String x:title)
      {   System.out.println(x);  }
   }
   public void getAnswer() {
      for(String x:answer)
      {   System.out.println(x);  }
   }
   public void getTitleAnswer() {  //查看题
      for(int i=0;i<title.length;i++)
      {   System.out.print("题目:"+title[i]); 
          System.out.print("答案:"+answer[i]); 
          System.out.println(); 
      }
   }
   public void inputTitleAnswer() //出题
   {   
        Scanner s=new Scanner(System.in);
        for(int i=0;i<title.length;i++)
        {   System.out.println("请输入第"+(i+1)+"题的题目:");
            title[i]=s.next();
            System.out.println("请输入第"+(i+1)+"题的答案,注意只能输入A、B、C、D:");
            answer[i]=s.next();
            System.out.println( );  
            System.out.println( );     
        }
    }
    public void editTitleAnswer()  //修改题目和答案
    {   Scanner s=new Scanner(System.in);
        int testNo;
        System.out.println("请输入要修改的题号: ");
        testNo=s.nextInt();
        if(testNo>=1 && testNo<=10) 
        {
               System.out.println("请输入第"+testNo+"题的题目:");
               title[testNo-1]=s.next();
               System.out.println("请输入第"+testNo+"题的答案,注意只能输入A、B、C、D:");
               answer[testNo-1]=s.next();
         }
         System.out.println( );  
         System.out.println( ); 
   }
}


public  class  MainTest4{
  static Teacher t[]=new Teacher[1000];  //假设最多有100个老师
  static int maxTeacher=0; //教师总人数
  public static void main(String[ ] args)
  {   Scanner input=new Scanner(System.in);
      int choose;
      boolean flag=true;
      while(flag)
     {   System.out.println();
         System.out.println("***************");
         System.out.println("*  1.教师系统 *");
         System.out.println("*  2.学生系统 *");
	 System.out.println("*  0.退    出 *");
	 System.out.println("***************");
	 System.out.println("请输入操作序号：");
	 choose=input.nextInt();
         switch(choose)
         {  
            case 1: teacher(); break;
            case 2: student( ); break;
            case 0: flag=false; break;
            default: flag=false; break;
         }
     }
     System.out.println("感谢您使用考试系统，祝您生活愉快！");
   }    

   static void teacher()  
   {                     
        Scanner input=new Scanner(System.in);
        System.out.println();
        System.out.println();
        boolean flag=true;
        int choose;
        while(flag) { 
         System.out.println();
         System.out.println("*********************");
         System.out.println("*    教 师 系 统    *");
         System.out.println("*    1.新增教师信息  *");
         System.out.println("*    2.出题         *");
	 System.out.println("*    3.查看和修改试题*");
	 System.out.println("*    0.退出教师系统 *");
	 System.out.println("********************");
	 System.out.println("请输入操作序号：");
	 choose=input.nextInt();
         switch(choose)
         {  
            case 1: inputTeacher(); break;
            case 2: inputTest(); break;
            case 3: viewTest(); break;
            case 0: flag=false; break;
            default: flag=false; break;
         }
      }
      
    }
  
   static void inputTeacher()   //新增教师
   {      
        int i=0;               
        
        Scanner s=new Scanner(System.in);
        int id;String name; String key;

        String ifContinue="N";
        boolean  flag=true;
        while(flag){
           System.out.println("请输入教师号:"); 
           id=s.nextInt();
           System.out.println("请输入教师姓名:"); 
           name=s.next();
           System.out.println("请输入教师登录密码:"); 
           key=s.next();

           t[i]=new Teacher();
           t[i].setBaseMessage(id,key,name);
           i++;
           System.out.println("是否继续录入教师信息(Y/N):"); 
           ifContinue=s.next();
           if( !(ifContinue.equals("Y") || ifContinue.equals("y")) )
               flag=false;
        }
        maxTeacher=i;  //记录目前教师总人数，因为i从0开始记录，所以maxTeacher=i+1
   }

   static void inputTest()   //出题
   {         
        Scanner s=new Scanner(System.in);
        int id;String name; String key;
        int i=0;
        
        System.out.println("教师号:"); 
        id=s.nextInt();
        System.out.println("请输入教师登录密码:"); 
        key=s.next();            
       
        boolean  flag=false;
        int nowteacher=0; //当前教师
        for(i=0;i<maxTeacher;i++)
           if(t[i].getId()==id && t[i].getKey().equals(key))
           {  flag=true; nowteacher=i; break; }

        if(flag)  //有这个教师，可以出题
        {   //出题
          t[nowteacher].inputTitleAnswer();
        }
        else
        {
        	System.out.println("没有这个教师或者密码错误！");
        }
   }

   static void viewTest()  
   {    
         System.out.println( );  
         System.out.println( );  
         Scanner s=new Scanner(System.in);
         int id;String name; String key;
         int i=0;
         
         System.out.println("教师号:"); 
         id=s.nextInt();
         System.out.println("请输入教师登录密码:"); 
         key=s.next();            
        
         boolean  flag=false;
         int nowteacher=0; //当前教师
         for(i=0;i<maxTeacher;i++)
            if(t[i].getId()==id && t[i].getKey().equals(key))
            {  flag=true; nowteacher=i; break; }

         if(flag)  //有这个教师，可以看题
         {   
        	 System.out.println("原题目：");
           t[nowteacher].getTitle();
           System.out.println("原答案");
           t[nowteacher].getAnswer();
           t[nowteacher].editTitleAnswer();
         }
         else 
         {
        	 System.out.println("密码错误或者没有这个老师");
         }
         
   }


   static void student( )  
   {    
        Scanner input=new Scanner(System.in);
        System.out.println();
        System.out.println();
        boolean flag=true;
        int choose;
        while(flag) { 
         System.out.println();
         System.out.println("********************");
         System.out.println("*    学生系统      *");
         System.out.println("*   1.测   试      *");
         System.out.println("*   2.查看得分     *");
	 System.out.println("*   3.查看答案     *");
	 System.out.println("*   0.退出学生系统 *");
	 System.out.println("*******************");
	 System.out.println("请输入操作序号：");
	 choose=input.nextInt();
         switch(choose)
         {  
            case 1: myTest(); break;
            case 2: viewScore( ); break;
            case 3: viewAnswer( ); break;
            case 0: flag=false; break;
            default: flag=false; break;
         }
      }
   }

   static void myTest( ) 
   {  
	   Scanner input=new Scanner(System.in);
	   System.out.println("请输入教师号：");
	   Student.teacherId=input.nextInt();
	   boolean  flag=false;
       int nowteacher=0; //当前教师
       for(int i=0;i<maxTeacher;i++)
          if(t[i].getId()==Student.teacherId )
          {  flag=true; nowteacher=i; break; }

       if(flag)  
       {   
    	   Student.answer();
       }
       else
       {
       	System.out.println("没有这个教师或者密码错误！");
       }
	   
	   for(int i=0;i<Student.answer.length;i++)
	   {
		   if(Student.answer[i].equals(t[nowteacher].answer[i]))Student.score+=10;
	   } 
         
  }

   static void viewScore( )  
   {
        System.out.println( );  
        System.out.println( ); 
        System.out.println("你的得分为："+Student.score ); 
        System.out.println( );  
        System.out.println( ); 
   } 

   static void viewAnswer( )  
   {
	   boolean  flag=false;
       int nowteacher=0; //当前教师
       for(int i=0;i<maxTeacher;i++)
          if(t[i].getId()==Student.teacherId )
          {  flag=true; nowteacher=i; break; }

       if(flag)  
       {   
    	   t[nowteacher].getAnswer();
       }
       else
       {
       	System.out.println("没有这个教师或者密码错误！");
       }
	   
   }   

}   

class Student
{
	public static int teacherId;
	public static String answer[]=new String[10];
	public static int score;
	 public static void answer() //出题
	   {   
	        Scanner s=new Scanner(System.in);
	        for(int i=0;i<answer.length;i++)
	        {   
	            System.out.println("请输入第"+(i+1)+"题的答案,注意只能输入A、B、C、D:");
	            answer[i]=s.next();
	            System.out.println( );  
	            System.out.println( );     
	        }
	    }
}