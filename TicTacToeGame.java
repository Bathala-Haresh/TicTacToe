/**
* This program is to As a Player would like to start fresh by creating a tictactoe board 
*
* @author  Bathala Haresh
*/

package com.workshop;
public class TicTacToeGameUC1{

	public static void main(String[] args) {
		TicTacToeGameUC1.emptyArray();

	}
	
	//method to create an empty array
	public static  void emptyArray()
	{
		char [][] Char=new char[3][3];

		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				System.out.println(Char[i][j]+ "  ");
			}
			System.out.print("\n");

		}
	}

}
