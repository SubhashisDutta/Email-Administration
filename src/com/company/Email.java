package com.company;
import java.util.*;
import java.io.*;
public class Email
{
	public Scanner sc=new Scanner(System.in);
	private String fname;
	private String lname;
	private String dept;
	private String email;
	private String password;
	private int mailCapacity=500;
	private String alter_email;

	//constructor to accept 1st and last name
	public Email(String fname, String lname){
		this.fname=fname; //this.fname is that upper private fname since both  both class variable are same. we use it to invoke class method/constructor 
		this.lname=lname;
		System.out.println("New employee:"+this.fname+""+this.lname);
		//calling methods
		this.dept=this.setDept();//dept
		this.password=this.generate_password(8);//password
		this.email=this.generate_email();//email
	}

	//generate mail method
	private String generate_email(){
		return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
	}

	//dept name
	private String setDept(){
		System.out.println("Department Codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for None");
		boolean flag=false;
		do{                                               // get executed atleast once
			System.out.println("Enter Department code");
			int choice=sc.nextInt();
			switch(choice){
				case 1:
					return "Sales";
				case 2:
					return "Development";
				case 3:
					return "Accounting";
				case 4:
					return "None";
				default:
				System.out.println("Invalid choice. Please choose again");
			}
		}
		while(!flag);
		return null;
	}

	//generate random password
	private String generate_password(int length)
	{
		Random r=new Random();
		String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars="abcdefghijklmnopqrstuvwxyz";
		String numbers="0123456789";
		String symbols="!@#$%&?";
		String values=Capital_chars+Small_chars+numbers+symbols;
		String password="";
		for(int i=0;i<length;i++)
		{
			password=password+values.charAt(r.nextInt(values.length()));
		}
		return password;
	}

	//change password
	public void set_password()
	{
		boolean flag=false;
		do{
			System.out.println("Change Password?(Y/N)");
			char choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
			{
				flag=true;
				System.out.println("Enter current password");
				String temp=sc.next();
				if(temp.equals(this.password))
				{
					System.out.println("Enter new password");
					this.password=sc.next();
					System.out.println("Password changed successfully");
				}
				else
				{
					System.out.println("Incorrect password");
				}
			}
				else if(choice=='n'||choice=='N')
				{
					flag=true;
					System.out.println("Password change option cancelled");
				}
			

				else{
					System.out.println("Enter valid choice");
				}
			
		}while(!flag);
	}
			
		

		//set mailbox capacity
		public void set_mailCap()
		{
			System.out.println("Current capacity= "+this.mailCapacity+"mb");
			System.out.println("Enter new mailbox capacity");
			this.mailCapacity=sc.nextInt();
			System.out.println("Mailbox capacity is successfully changed");
		}

		//setting alternate mail
		public void alternate_email()
		{
			System.out.println("Enter new alternate mail:");
			this.alter_email=sc.next();
			System.out.println("Your alternate email is set");

		}

		//Display method
		public void getInfo()
		{
			System.out.println("New:"+this.fname+" "+this.lname);
			System.out.println("Department:"+this.dept);
			System.out.println("Email:"+this.email);
			System.out.println("Password:"+this.password);//showing this only for checking purpose
			System.out.println("Mailbox capacity:"+this.mailCapacity+"mb");
			System.out.println("Alternate mail:"+this.alter_email);
		}

		public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first name:");
		String f_name=sc.next();
		System.out.println("Enter last name:");
		String l_name=sc.next();

		//creating obj for email class
		Email em1=new Email(f_name,l_name);
		int choice=-1;
		do
		{
			System.out.println("\n******\nEnter your choice\n1.Show Info\n3.Change mailbox capacity\n4.Set alternate mail\n5.Exit");
			choice=sc.nextInt();
			switch(choice){
				case 1:
				    em1.getInfo();
				    break;
				case 2:
					em1.set_password();
					break;
				case 3:
					em1.set_mailCap();
					break;
				case 4:
					em1.alternate_email();
					break;
				case 5:
					System.out.println("Thank You!");
					break;
				default:
					System.out.println("Invalid choice. Enter proper choice");

			}
		}while(choice!=5);
	}
}
	

	




				
	

			

		

	
