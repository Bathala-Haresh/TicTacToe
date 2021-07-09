/**
 * Ability for user to make a move to a desired location in the board - Select the index from 1 to 9 to make the move. Ensure the index is free
 *
 * @author  Bathala Haresh
 */

package com.workshop;
import java.util.Scanner;
public class TicTacToeGameUC4
{
	//method to ask user  
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
		if(x[i]=='*')
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
	public static void main(String[] args) {
		char[] ticTacToe=new char[9];
		for(int i=0;i<=8;i++)
		{
			ticTacToe[i]='*';
		}
		char [] Pawns=new char[2];
		showBoard(ticTacToe);
		Pawns=choosePawn(Pawns);
	}
}