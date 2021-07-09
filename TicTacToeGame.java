/**
 * As a Player would like to see the board so I can choose the valid cells to make my move during my turn
 *
 * @author  Bathala Haresh
 */

package com.workshop;

import java.util.Scanner;
public class TicTacToeGameUC3
{
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
		System.out.println("The Player Pawn is   : "+x[0]);
		System.out.println("The Computer Pawn is  : "+x[1]);

		return x;
	}
	//method to display the Board
	public static void showBoard(char[] x)
	{
		for(int i=0;i<=8;i++)
		{
			System.out.print(x[i]+" ");
			//we are starting from 0th index so we are incrementing it by 1
			int a=i+1;
			if(a%3==0)
			{
				System.out.print("\n");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose the Pawn\n1.X\n2.O");
		System.out.print("Your Pawn Choice:");
		int choice=sc.nextInt();

		//declaring an array
		char[] TicTac=new char[9];
		//filling board with stars
		for(int i=0;i<=8;i++)
		{
			TicTac[i]='*';
		}
		//declaring an array
		char [] pawns=new char[2];
		//assigning TicTac to showBoard method
		showBoard(TicTac);
		pawns=choosePawn(pawns,choice);
		sc.close();
	}
}