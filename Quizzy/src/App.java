import java.util.Scanner;
import java.sql.*;

public class App{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to the Quizzy!");
        System.out.println("Developed by krishnaa6268(वयम्)");

        System.out.print("Please Enter your name: ");
        String name= sc.nextLine();

        System.out.println("Please Enter your Choice:\n 1. Computer Fundamental. \n 2. Mathematics. \n 3. Exit.\n");
        int choice= sc.nextInt();

        switch (choice) {
            case 1:
                Computer(name);
                break;
            case 2:
                Mathematics(name);
                break;
            default:
                break;
        }
        sc.close();
    }


    public static void Computer(String name)
    {
        int score=0;
        
      try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizz", "root", "Doraemon");)
      {
          Scanner sc= new Scanner(System.in);
        //  System.out.println("Connection ID: "+con);
          Statement stmt =con.createStatement();
          ResultSet rs1 =stmt.executeQuery("select * from comp");
          
          int flag=0;
            while(rs1.next())
            {
                System.out.print("Q"+rs1.getInt(1)+". " +rs1.getString(2)+"\n(1)"+rs1.getString(3)+"\n(2)" 
                +rs1.getString(4)+"\n(3)"+rs1.getString(5)+"\n(4)"+rs1.getString(6)+"\n");

                System.out.println("Choose an option(1,2,3,4): ");
                int op = sc.nextInt();
                String userOpt = null;
                System.out.println();

                op=op+2;
                if ( op >= 3 && op<=6)
                {
                  userOpt = rs1.getString(op);
                  //System.out.println("\topt:"+userOpt); //-------------------------------------

                    if(AnsComp(flag).equals(userOpt))
                    {
                        score = score+20;
                    }
                }
                else{
                  System.out.println("Choose a right one...");
                }
                flag++; 

               // System.out.println("------------Score:"+score+" ______Flag"+flag); //----------------------
            }
            status(score, name);     
            sc.close();
            con.close();
        }
        catch (Exception e)
        {
          System.out.println(e);
        }

    }


    public static void Mathematics(String name)
    {
        int score=0;
        
      try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizz", "root", "Doraemon");)
      {
          Scanner sc= new Scanner(System.in);
        //  System.out.println("Connection ID: "+con);
          Statement stmt =con.createStatement();
          ResultSet rs1 =stmt.executeQuery("select * from math");
          
          int flag=0;
            while(rs1.next())
            {
                System.out.print("Q"+rs1.getInt(1)+". " +rs1.getString(2)+"\n(1)"+rs1.getString(3)+"\n(2)" 
                +rs1.getString(4)+"\n(3)"+rs1.getString(5)+"\n(4)"+rs1.getString(6)+"\n");

                System.out.println("Choose an option(1,2,3,4): ");
                int op = sc.nextInt();
                System.out.println();
                String userOpt = null;

                op=op+2;
                if ( op >= 3 && op<=6)
                {
                  userOpt = rs1.getString(op);
                  //System.out.println("\topt:"+userOpt); //-------------------------------------

                    if(AnsMath(flag).equals(userOpt))
                    {
                        score = score+20;
                    }
                }
                else{
                  System.out.println("Choose a right one...");
                }
                flag++; 

               // System.out.println("------------Score:"+score+" ______Flag"+flag); //----------------------
            }
            status(score, name);     
            sc.close();
            con.close();
        }
        catch (Exception e)
        {
          System.out.println(e);
        }

    }


    public static String AnsComp(int flag)
    {
        String[] arr = new String[5];
      
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizz", "root", "Doraemon");)
        {
            Statement stmt =con.createStatement();
            ResultSet rs1 =stmt.executeQuery("select Ans from compAns");
          
            int i=0;
            while(rs1.next())
            { 
              arr[i]=(rs1.getString(1));
              i++;
            }
            con.close();
        }
        catch (Exception e)
        {
          System.out.println(e);
        }

        String ret=arr[flag];
        return ret;
    }

    public static String AnsMath(int flag)
    {
        String[] arr = new String[5];
      
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizz", "root", "Doraemon");)
        {
            Statement stmt =con.createStatement();
            ResultSet rs1 =stmt.executeQuery("select Ans from mathAns");
          
            int i=0;
            while(rs1.next())
            { 
              arr[i]=(rs1.getString(1));
              i++;
            }
            con.close();
        }
        catch (Exception e)
        {
          System.out.println(e);
        }

        String ret=arr[flag];
        return ret;
    }

    public static void status(int score, String name)
    {
        if (score>=60){
            System.out.printf("Dear %s,You have passed! \nScore: %d", name, score);
        }
        else{
            System.out.printf("Dear %s, The future will change your fate again... \n Score: %d", name, score);
        }
    }
}
