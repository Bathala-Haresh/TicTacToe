package com.workshop;
import java.util.Scanner;


public class TicTacToeGame {

	public static void main(String[] args) {
		TicTacToeGame ticTacToeGame=new TicTacToeGame();
		ticTacToeGame.emptyArray();

	}
	// method to create an empty array
	public void emptyArray()
	{
		Scanner sc=new Scanner(System.in);
		int step=1;
		char [][] javaCharArray=new char[3][3];

		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				System.out.println(javaCharArray[i][j]+ " ");
			}

		}
	}

}
