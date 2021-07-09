/**
 * This program is ability to allow the player to choose letter X or O
 *
 * @author  Bathala Haresh
 */
package com.workshop;
import java.util.Scanner;
public class TicTacToeGameUC2
{
	//method which takes char array and choice by user and assigns the pawn
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


	public static void main(String[] args) {
		//declaring character array of size 2
		char [] pawns=new char[2];

		Scanner sc=new Scanner(System.in);
		System.out.println("Choose the Pawn\n1.X\n2.O");
		System.out.print("Your Pawn Choice:");
		int choice=sc.nextInt();
		sc.close();
		pawns=choosePawn(pawns,choice);


	}
}