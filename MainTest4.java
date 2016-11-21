package homework;
import java.util.Scanner;
class  Teacher
{
   private int id;
   private String key;
   private String name;
   public String title[]=new String[10]; //��Ŀ
   public String answer[]=new String[10];//��
  

   private static int TeacherNumber=0;  //��ʦ������

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
   public void getTitleAnswer() {  //�鿴��
      for(int i=0;i<title.length;i++)
      {   System.out.print("��Ŀ:"+title[i]); 
          System.out.print("��:"+answer[i]); 
          System.out.println(); 
      }
   }
   public void inputTitleAnswer() //����
   {   
        Scanner s=new Scanner(System.in);
        for(int i=0;i<title.length;i++)
        {   System.out.println("�������"+(i+1)+"�����Ŀ:");
            title[i]=s.next();
            System.out.println("�������"+(i+1)+"��Ĵ�,ע��ֻ������A��B��C��D:");
            answer[i]=s.next();
            System.out.println( );  
            System.out.println( );     
        }
    }
    public void editTitleAnswer()  //�޸���Ŀ�ʹ�
    {   Scanner s=new Scanner(System.in);
        int testNo;
        System.out.println("������Ҫ�޸ĵ����: ");
        testNo=s.nextInt();
        if(testNo>=1 && testNo<=10) 
        {
               System.out.println("�������"+testNo+"�����Ŀ:");
               title[testNo-1]=s.next();
               System.out.println("�������"+testNo+"��Ĵ�,ע��ֻ������A��B��C��D:");
               answer[testNo-1]=s.next();
         }
         System.out.println( );  
         System.out.println( ); 
   }
}


public  class  MainTest4{
  static Teacher t[]=new Teacher[1000];  //���������100����ʦ
  static int maxTeacher=0; //��ʦ������
  public static void main(String[ ] args)
  {   Scanner input=new Scanner(System.in);
      int choose;
      boolean flag=true;
      while(flag)
     {   System.out.println();
         System.out.println("***************");
         System.out.println("*  1.��ʦϵͳ *");
         System.out.println("*  2.ѧ��ϵͳ *");
	 System.out.println("*  0.��    �� *");
	 System.out.println("***************");
	 System.out.println("�����������ţ�");
	 choose=input.nextInt();
         switch(choose)
         {  
            case 1: teacher(); break;
            case 2: student( ); break;
            case 0: flag=false; break;
            default: flag=false; break;
         }
     }
     System.out.println("��л��ʹ�ÿ���ϵͳ��ף��������죡");
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
         System.out.println("*    �� ʦ ϵ ͳ    *");
         System.out.println("*    1.������ʦ��Ϣ  *");
         System.out.println("*    2.����         *");
	 System.out.println("*    3.�鿴���޸�����*");
	 System.out.println("*    0.�˳���ʦϵͳ *");
	 System.out.println("********************");
	 System.out.println("�����������ţ�");
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
  
   static void inputTeacher()   //������ʦ
   {      
        int i=0;               
        
        Scanner s=new Scanner(System.in);
        int id;String name; String key;

        String ifContinue="N";
        boolean  flag=true;
        while(flag){
           System.out.println("�������ʦ��:"); 
           id=s.nextInt();
           System.out.println("�������ʦ����:"); 
           name=s.next();
           System.out.println("�������ʦ��¼����:"); 
           key=s.next();

           t[i]=new Teacher();
           t[i].setBaseMessage(id,key,name);
           i++;
           System.out.println("�Ƿ����¼���ʦ��Ϣ(Y/N):"); 
           ifContinue=s.next();
           if( !(ifContinue.equals("Y") || ifContinue.equals("y")) )
               flag=false;
        }
        maxTeacher=i;  //��¼Ŀǰ��ʦ����������Ϊi��0��ʼ��¼������maxTeacher=i+1
   }

   static void inputTest()   //����
   {         
        Scanner s=new Scanner(System.in);
        int id;String name; String key;
        int i=0;
        
        System.out.println("��ʦ��:"); 
        id=s.nextInt();
        System.out.println("�������ʦ��¼����:"); 
        key=s.next();            
       
        boolean  flag=false;
        int nowteacher=0; //��ǰ��ʦ
        for(i=0;i<maxTeacher;i++)
           if(t[i].getId()==id && t[i].getKey().equals(key))
           {  flag=true; nowteacher=i; break; }

        if(flag)  //�������ʦ�����Գ���
        {   //����
          t[nowteacher].inputTitleAnswer();
        }
        else
        {
        	System.out.println("û�������ʦ�����������");
        }
   }

   static void viewTest()  
   {    
         System.out.println( );  
         System.out.println( );  
         Scanner s=new Scanner(System.in);
         int id;String name; String key;
         int i=0;
         
         System.out.println("��ʦ��:"); 
         id=s.nextInt();
         System.out.println("�������ʦ��¼����:"); 
         key=s.next();            
        
         boolean  flag=false;
         int nowteacher=0; //��ǰ��ʦ
         for(i=0;i<maxTeacher;i++)
            if(t[i].getId()==id && t[i].getKey().equals(key))
            {  flag=true; nowteacher=i; break; }

         if(flag)  //�������ʦ�����Կ���
         {   
        	 System.out.println("ԭ��Ŀ��");
           t[nowteacher].getTitle();
           System.out.println("ԭ��");
           t[nowteacher].getAnswer();
           t[nowteacher].editTitleAnswer();
         }
         else 
         {
        	 System.out.println("����������û�������ʦ");
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
         System.out.println("*    ѧ��ϵͳ      *");
         System.out.println("*   1.��   ��      *");
         System.out.println("*   2.�鿴�÷�     *");
	 System.out.println("*   3.�鿴��     *");
	 System.out.println("*   0.�˳�ѧ��ϵͳ *");
	 System.out.println("*******************");
	 System.out.println("�����������ţ�");
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
	   System.out.println("�������ʦ�ţ�");
	   Student.teacherId=input.nextInt();
	   boolean  flag=false;
       int nowteacher=0; //��ǰ��ʦ
       for(int i=0;i<maxTeacher;i++)
          if(t[i].getId()==Student.teacherId )
          {  flag=true; nowteacher=i; break; }

       if(flag)  
       {   
    	   Student.answer();
       }
       else
       {
       	System.out.println("û�������ʦ�����������");
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
        System.out.println("��ĵ÷�Ϊ��"+Student.score ); 
        System.out.println( );  
        System.out.println( ); 
   } 

   static void viewAnswer( )  
   {
	   boolean  flag=false;
       int nowteacher=0; //��ǰ��ʦ
       for(int i=0;i<maxTeacher;i++)
          if(t[i].getId()==Student.teacherId )
          {  flag=true; nowteacher=i; break; }

       if(flag)  
       {   
    	   t[nowteacher].getAnswer();
       }
       else
       {
       	System.out.println("û�������ʦ�����������");
       }
	   
   }   

}   

class Student
{
	public static int teacherId;
	public static String answer[]=new String[10];
	public static int score;
	 public static void answer() //����
	   {   
	        Scanner s=new Scanner(System.in);
	        for(int i=0;i<answer.length;i++)
	        {   
	            System.out.println("�������"+(i+1)+"��Ĵ�,ע��ֻ������A��B��C��D:");
	            answer[i]=s.next();
	            System.out.println( );  
	            System.out.println( );     
	        }
	    }
}