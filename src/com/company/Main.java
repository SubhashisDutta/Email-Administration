package com.company;
import java.util.*;
    public class Main
    {
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

