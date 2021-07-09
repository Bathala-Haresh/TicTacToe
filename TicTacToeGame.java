/**
 * As player would expect the Tic Tac Toe App to determine after every move the winner or the tie or change the turn
 *
 * @author  Bathala Haresh
 */
package com.workshop;

import java.util.Scanner;
public class TicTacToeGameUC7
{
	//method to choose your pawn like either X or O
	public static char[] choosePawn(char[] x)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose the Pawn\n1.X\n2.O");
		System.out.print("Your Pawn Choice:");
		int choice=sc.nextInt();
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
	//method to create a visual Game Board
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
	//returns the random number between max and min
	public static int getRandomNumber(int min, int max) 
	{
		return (int) ((Math.random() * (max - min)) + min);
	}
	//toss to choose who starts the game
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
	//method to check rows and char Y is {X,O}
	public static int rowWinCheck(char[] x,char y)
	{
		for(int i=0;i<=2;i++)
		{
			if(x[i]==y&&x[i+3]==y&&x[i+6]==y)
			{
				return 1;
			}
			return 0;
		}
		return 100;
	}
	//method to check coloumn and char Y is {X,O}
	public static int columnWinCheck(char[] x,char y)
	{
		for(int i=0;i<=8;i++)
		{
			if(x[i]==y&&x[i+1]==y&&x[i+2]==y)
			{
				return 1;
			}
			i=i+2;
		}
		return 0;
	}
	//method to check diagnols 
	public static int diagnolWinCheck(char[] x,char y)
	{
		if(x[0]==y&&x[4]==y&&x[8]==y)
		{
			return 1;
		}
		if(x[2]==y&&x[4]==y&&x[6]==y)
		{
			return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		char[] TicTac=new char[9];
		for(int i=0;i<=8;i++)
		{
			TicTac[i]='*';
		}
		char [] Pawns=new char[2];
		showBoard(TicTac);
		Pawns=choosePawn(Pawns);
	}
}