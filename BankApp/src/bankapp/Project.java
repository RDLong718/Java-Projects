/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.util.*;
//import java.util.Hashtable;
import java.io.*;

class Project1{
  public static void main(String[] args){
    Scanner in=new Scanner(System.in); 
    String inname1="Chase"; //Example Names of Banks and thier amounts for each
    double inbalance1=321;
    String inname2="American Express";
    double inbalance2=123;
    String inname3="Citi";
    double inbalance3=111;
    int n=3;
    
    Banks[] barr=new Banks[n];
    Banks[] blankbarr=new Banks[n];
    QueueList queue = new QueueList();
    
    Banks[] barr1=new Banks[n]; //Bank Array for USER 0
    barr1[0]= new Banks(inname1,inbalance1); //Example Bank names and amounts
    barr1[1]= new Banks();
    barr1[1].setName(inname2);
    barr1[1].setBal(inbalance2);
    barr1[2]=new Banks(inname3,inbalance3);
    System.out.println(barr1[0]+" N:"+barr1[0].getName()+" B:"+barr1[0].getBal()); //Prints Memory Location, Name, Balance
    //System.out.println(barr1[1]+" N:"+barr1[1].getName()+" B:"+barr1[1].getBal());
    //System.out.println(barr1[2]+" N:"+barr1[2].getName()+" B:"+barr1[2].getBal());

    Banks[] barr2=new Banks[n];//Bank Array for USER 1
    barr2[0]=new Banks("American", 100);//Example Names of Banks and thier amounts for each
    barr2[1]=new Banks("Discover", 510);
    barr2[2]=new Banks("HSBC", 202);
    System.out.println(barr2[0]+" N:"+barr2[0].getName()+" B:"+barr2[0].getBal());//Prints Memory Location, Name, Balance
    
    Banks[] barr3=new Banks[n];//Bank Array for USER 2
    barr3[0]=new Banks("Ally", 2000000);//Example Names of Banks and thier amounts for each
    barr3[1]=new Banks("Valley", 25);
    barr3[2]=new Banks("Chase", 2050);
    System.out.println(barr3[0]+" N:"+barr3[0].getName()+" B:"+barr3[0].getBal());//Prints Memory Location, Name, Balance
    
    //System.out.print("Enter Number of Users: ");
    //n=in.nextInt();
    Hashtable<Integer,Banks[]> users = new Hashtable<Integer,Banks[]>(); //Initialize Hash of User Accounts
    /*for(int x=0;x<n-1;x++){ //Used to Bind the next Key to the seperate Banks[]
      System.out.println("Enter Name: ");
      s=in.next();
      users.put(x,barr);
    }*/
    
    users.put(0,barr1);// USER 0
    users.put(1,barr2);// USER 1
    users.put(2,barr3);// USER 2

    System.out.println("HASH: " + users +"\n"); 
    
    //------------------------------------------------------ 
    
    System.out.println("Welcome To The Bank");
    boolean stop=false;
    boolean stop2=false;
    boolean stop3=false;
    Integer unum, bnum;//user number
    String fname, command;//find name, input command
    double amountw, amountd;//amount withdrew, amount deposited
    
    command="";
    while(stop3==false){
      System.out.print("Please enter your Account ID: ");
      unum=in.nextInt();
       if(users.containsKey(unum)){ //Returns true if Key Exists
        System.out.println();
        barr=users.get(unum); //Sets barr to the specified USER NUMBER
        while(stop==false){
          System.out.println("What Would You Like To Do? \n1)Find Bank Name \n2)Add Bank");
          System.out.println("3)Sort \n4)Print Banks \n5)Total Amount \n6)Exit");
          System.out.println("PLEASE USE NUMBERS FOR MENU OPTIONS");
          command=in.next();
          System.out.println("----------");
          if(command.equals("1")){//Find Account
            System.out.print("What Is The Name Of The Bank?:");
            print(n,barr);
            fname=in.next();
            System.out.println("----------");
            bnum=find(n,barr,fname);//Finds Bank Using Bank Name
            if(bnum!=-1){
              while(stop2==false){
                System.out.println("What Would You Like To Do? \n1)Check Balance \n2)Withdraw \n3)Deposit \n4)Delete \n5)Exit");
                System.out.println("PLEASE USE NUMBERS FOR MENU OPTIONS");
                command=in.next();
                System.out.println("----------");
                if(command.equals("1")){//Check Balance
                  System.out.println("Balance:"+barr[bnum].getBal());
                }else if(command.equals("2")){//Withdraw
                  System.out.print("Withdraw Amount:");
                  amountw=in.nextDouble();1
                  withdrawl(unum,bnum,barr,amountw,queue);
                  System.out.println("Balance:"+barr[bnum].getBal());
                }else if(command.equals("3")){//Deposit
                  System.out.print("Deposit Amount:");
                  amountd=in.nextDouble();
                  deposit(unum,bnum,barr,amountd,queue);
                  System.out.println("Balance:"+barr[bnum].getBal());
                }else if(command.equals("4")){//Delete
                  stop2=true;
                  n=delete(n,bnum,barr);
                  fname="null";
                  command="null";
                }else if(command.equals("5")){//Exit
                  stop2=true;
                  fname="null";
                  command="null";
                }
                System.out.println("----------");
              }stop2=false;
            }
            if(bnum==-1){System.out.println("-----Bank Name Not Found-----\n");}
          }bnum=-1;
          if(command.equals("2")){//Add Bank Account
            n=addBank(n,barr,in);
          }
          if(command.equals("3")){//Sort
            System.out.println("BEFORE-----------------");
            print(n,barr);
            sort(n,barr);
            System.out.println("AFTER------------------");
            print(n,barr);
          }
          if(command.equals("4")){//Print All Bank Accounts and Amounts
            print(n,barr);
          }
          if(command.equals("5")){//Total Amount of combined Banks
            System.out.println("Total: $"+total(n,barr));
          }
          if(command.equals("6")){//Exit
            stop=true;
            System.out.println("Goodbye");
          }
          System.out.println("----------");
        }
       }
       else{
         System.out.println("USER INVALID");
         stop3=true;
       }
       stop2=false;
       stop=false;
       bnum=null;
       unum=null;
       barr=blankbarr;
    }
    in.close();
    System.out.println("POST MAIN---------------------------------------------"); 

    //queue.enque(barr,unum,barr[unum].getName(),"Deposit", 50.75); //EXAMPLE QUEUE ENTRIES
    barr=users.get(0);//Sends barr according to unum
    queue.enque(users.get(0),0,barr[2].getName(),"Deposit", 5417);
    queue.enque(users.get(0),0,barr[1].getName(),"Withdraw", 117);
    queue.enque(users.get(0),0,barr[0].getName(),"Deposit", 112);
    barr=users.get(1);
    queue.enque(users.get(1),1,barr[1].getName(),"Deposit", 1515);
    queue.enque(users.get(1),1,barr[0].getName(),"Deposit", 707);
    queue.enque(users.get(1),1,barr[1].getName(),"Withdraw", 150);
    barr=users.get(2);
    queue.enque(users.get(2),2,barr[2].getName(),"Withdraw", 23);
    queue.enque(users.get(2),2,barr[0].getName(),"Withdraw", 8008);
    
    //To display the total number of transection of that perticular user/account'
    System.out.println("QUEUE SIZE: ");
    System.out.println(queue.size());
    //To display whole transection of the certain period let's say a week/month
    System.out.println("QUEUE: ");
    queue.display();
    //System.out.println(barr[unum].getName());
  }
  
//MAIN----------------------------------------------------------------------------------------------------------------- 
  public static int addBank(int n,Banks[] barr,Scanner in){ //Adds Bank to User Account
    barr[barr.length-1]=new Banks();
    System.out.println("ENTER NAME:");
    barr[barr.length-1].setName(in.next());
    System.out.println("ENTER VALUE:");
    barr[barr.length-1].setBal(in.nextDouble());
    return n;
  }
  public static void print(int n, Banks[] barr){ //Prints All Bank Amounts
    for(int i=0;i<n;i++){
      System.out.println("Name:"+barr[i].getName()+"\n"+"     Balance:"+barr[i].getBal());
    }
  }
  public static void sort(int n, Banks[] barr){ 
    boolean done;
    double tempd;
    String temps;
    String name1;
    String name2;
    double bal1;
    double bal2;
    for(int i=0;i<n-1;i++){
      done=false;
      for(int j=0;j<n-i-1;j++){
        name1= barr[j].getName();
        name2= barr[j+1].getName();
        bal1= barr[j].getBal();
        bal2= barr[j+1].getBal();
        if(name1.compareTo(name2)>=0){
          tempd=bal1;
          temps=name1;
          barr[j].setBal(bal2);
          barr[j].setName(name2);
          barr[j+1].setBal(tempd);
          barr[j+1].setName(temps);
          done=true;
        //SORT BY BALANCE
        /*if(balance[j]>balance[j+1]){
          tempi=balance[j];
          temps=acctname[j];
          balance[j]=balance[j+1];
          acctname[j]=acctname[j+1];
          balance[j+1]=tempi;
          acctname[j+1]=temps;
          done=true;
          }*/
        }
      }
      if(done==false){
        break;
      }
    }
  }
  public static int total(int n, Banks[] barr){ //Prints Total of Bank Accounts for the User
    int tot=0;
    for(int i=0;i<n;i++){
      tot+=barr[i].getBal();
    }return tot;
  }
  public static int find(int n, Banks[] barr, String fname){ //Finds Bank within Users Account
    for(int i=0;i<n;i++){
      if(fname.equals(barr[i].getName())==true){
        return i;
      }
    }return -1;
  }
  public static void withdrawl(int unum,int bnum,Banks[] barr,double amount,QueueList queue){ //Withdraw from Bank
    barr[bnum].subBal(amount);
    queue.enque(barr,unum,barr[bnum].getName(),"Withdraw", amount);
  }
  public static void deposit(int unum,int bnum,Banks[] barr,double amount,QueueList queue){ //Deposit from Bank
    barr[bnum].addBal(amount);
    queue.enque(barr,unum,barr[bnum].getName(),"Deposit", amount);
  }
  public static int delete(int n,int bnum,Banks[] barr){ //Deletes Bank Info
    for(int i=bnum;i<n-1;i++){
      barr[i].setName(barr[i+1].getName());
      barr[i].setBal(barr[i+1].getBal());
    }
    barr[n-1].setName("null");
    barr[n-1].setBal(0.0);
    return n--;
  }
}
class Banks{
  String bnames;
  double bbalance;
  
  Banks(){
    bnames="null";
    bbalance=0.0;
  }
  Banks(String newname,double newbalance){ //Passed name and balance for Bank
    bnames=newname;
    bbalance=newbalance;
  }
  public void setName(String name){ //Sets new Name for Bank
    bnames=name;
  }
  public void setBal(double balance){ //Sets new Balance for Bank
    bbalance=balance;
  }
  String getName(){ //Returns Bank Name
    return bnames;
  }
  double getBal(){ //Returns Bank Balance
    return bbalance;
  }
  double addBal(double amount){ //Increases Bank Balance
    bbalance+=amount;
    return bbalance;
  }
  double subBal(double amount){ //Decreases Bank Balance
    bbalance-=amount;
    return bbalance;
  }
}
class QueueList {
  private class NodeQue{
    String transectionType;
    double amount;
    int unum;
    String barrname;
    NodeQue next2;
    public NodeQue(int unum,String barrname, String transectionType, double amount) {
      String val = transectionType.toUpperCase();
      this.unum = unum;
      this.barrname = barrname;
      this.transectionType = val;
      this.amount = amount;
    }
  }
  private NodeQue head2,tail2;
  private int cntNode;
  public void enque(Banks[] barr,int unum,String barrname, String transectionType, double amount) {
    NodeQue node = new NodeQue(unum,barrname,transectionType, amount);
    cntNode++;
    if(head2 == null) {
      head2=tail2=node;
      return;
    }
    tail2.next2 = node;
    tail2 = node;
  }
  public double deque() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    double result = head2.amount;
    NodeQue current = head2.next2;
    head2.next2 = null;
    head2 = current;
    cntNode--;
    return result;
  }
  /*public double totalBalance() {
   NodeQue current = head2;
   //StackList deposit = new StackList();
   //StackList withdraw = new StackList();
   double depositTotal = 0.0; double withdrawTotal = 0.0;
   while(current != null) {
   if(current.transectionType.equals("DEPOSIT"))
   depositTotal += (current.amount);
   else
   withdrawTotal += (current.amount);
   }
   return depositTotal-withdrawTotal;
   }*/
  public int size() {
    return cntNode;
  }
  public boolean isEmpty() {
    return size() == 0;
  }
  public void display() {
    NodeQue temp = head2;
    while(temp != null) {
      System.out.println("User " + temp.unum + " " +temp.barrname+" "+temp.transectionType+" "+temp.amount);
      temp = temp.next2;
    }
  }
}