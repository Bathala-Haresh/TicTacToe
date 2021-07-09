/**
 * As a User would like to do a toss to check who plays first.
 *
 * @author  Bathala Haresh
 */


package com.workshop;
import java.util.Scanner;
public class TicTacToeGameUC6
{
	//method to ask user to choose X or O
    public static char[] choosePawn(char[] x,int choice)
    {
       
	    if(choice==1)
	    {
	       x[1]='O';
	       x[0]='X';
	    }
	    else
	    {
	       x[0]='O';
	       x[1]='X';
	    }
	    System.out.println("The Player Pawn is"+x[0]);
	    System.out.println("The Player Pawn is"+x[1]);
	    
        return x;
    }
  //checking availability of free space ,if it is * then empty else it is filled with other player
    public static int checkAvailability(char[] x,int i)
    {
        if(x[i-1]=='*')
        {
            return 1;
        }
        return 0;
    }
    public static void showBoard(char[] x)
    {
        for(int i=0;i<=8;i++)
        {
            System.out.print(x[i]+" ");
            int a=i+1;
            if(a%3==0)
            {
                System.out.println();
            }
        }
    }
    //method that gives random numbers within that range
    public static int getRandomNumber(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
    //method to print the toss and prnting with name who won the toss
    public static int toss(String x)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("------Toss Time-------");
	    System.out.println("1.Heads\t2.Tails");
	    int tosschoosen=sc.nextInt();
	    int tossgot=getRandomNumber(1,3);
	    if(tosschoosen==tossgot)
	    {
	        System.out.println("---"+x+" Won the Toss----");
	        return 0;
	    }
	    else
	    {
	        System.out.println("---Computer Won the Toss----");
	        return 1;
	    }
    }

    public static void main(String[] args) {
        char[] TicTac=new char[9];
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose the Pawn\n1.X\n2.O");
        System.out.print("Your Pawn Choice:");
	    int choice=sc.nextInt();
        for(int i=0;i<=8;i++)
        {
            TicTac[i]='*';
        }
	    char [] Pawns=new char[2];
	    showBoard(TicTac);
	    Pawns=choosePawn(Pawns,choice);
    }
}