/**
 * As a player would play till the game is over
 *
 * @author  Bathala Haresh
 */


package com.workshop;
import java.util.Scanner;

public class TicTacToeGameUC12
{
	//returns the random number between max and min
	public static int getRandomNumber(int min, int max) 
	{
		return (int) ((Math.random() * (max - min)) + min);
	}
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
		return x;
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
				System.out.print("\n");
			}
		}
	}
	//toss to choose who starts the game 
	public static int toss(String x)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("------Toss Time-------");
		System.out.println("1.Heads\t2.Tails");
		int tossChoosen=sc.nextInt();
		int tossGot=getRandomNumber(1,3);
		if(tossChoosen==tossGot)
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
	//method to autoPlay by the computer 
	public static int computerMove(char[] x,char y)
	{
		//for loop to check rows 
		for(int i=0;i<=2;i++)
		{
			if(x[i]==y&&x[i+3]==y&&x[i+6]=='*')
			{
				return i+6;
			}
			if(x[i]==y&&x[i+6]==y&&x[i+3]=='*')
			{
				return i+3;
			}
			if(x[i+3]==y&&x[i+6]==y&&x[i]=='*')
			{
				return i;
			}
		}
		//for loop to check coloumns
		for(int i=0;i<=8;i++)
		{
			if(x[i]==y&&x[i+1]==y&&x[i+2]=='*')
			{
				return i+2;
			}
			if(x[i]==y&&x[i+2]==y&&x[i+1]=='*')
			{
				return i+1;
			}
			if(x[i+2]==y&&x[i+1]==y&&x[i]=='*')
			{
				return i;
			}
			i=i+2;
		}
		//for loop to check Diagnols
		if(x[0]==y&&x[4]==y&&x[8]=='*')
		{
			return 8;
		}
		if(x[4]==y&&x[8]==y&&x[0]=='*')
		{
			return 0;
		}
		if(x[0]==y&&x[8]==y&&x[4]=='*')
		{
			return 4;
		}
		if(x[2]==y&&x[4]==y&&x[6]=='*')
		{
			return 6;
		}
		if(x[4]==y&&x[6]==y&&x[2]=='*')
		{
			return 2;
		}
		if(x[2]==y&&x[6]==y&&x[4]=='*')
		{
			return 4;
		}
		return 100;
	}

	//method to check alternative moves 
	public static int alternateMove(char[] x)
	{
		if(x[0]=='*')
		{
			return 0;
		}
		if(x[2]=='*')
		{
			return 2;
		}
		if(x[6]=='*')
		{
			return 6;
		}
		if(x[8]=='*')
		{
			return 8;
		}
		if(x[4]=='*')
		{
			return 4;
		}
		if(x[1]=='*')
		{
			return 1;
		}
		if(x[3]=='*')
		{
			return 3;
		}
		if(x[5]=='*')
		{
			return 5;
		}
		if(x[7]=='*')
		{
			return 7;
		}
		return 100;
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

	//method to check columns and char Y is {X,O}
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
	//method to check Diagnols and char Y is {X,O}
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
	//method to play the TicTacToe Game
	public static void game(String x,char[] Pawns,int toss)
	{
		Scanner sc=new Scanner(System.in);
		//created an TicTac charArray
		char[] TicTac = new char[10];
		int current=toss;
		//initializing the TicTac charArray with *
		for(int i=0;i<=8;i++)
		{
			TicTac[i]='*';
		}
		for(int i=0;i<=8;i++)
		{
			if(current==1)
			{
				System.out.println("The Computer turn:");
				//displaying the TicTacToe Board
				showBoard(TicTac);
				//checking the computerMove method like checking with all rows,coloumns and diagnols and assign 1 index to the step
				int step=computerMove(TicTac,Pawns[1]);
				if(step>8)
				{
					step=computerMove(TicTac,Pawns[0]);
					if(step>8)
					{
						step=alternateMove(TicTac);
						TicTac[step]=Pawns[1];
					}
					else
					{
						TicTac[step]=Pawns[1];
					}
				}
				else
				{
					TicTac[step]=Pawns[1];
				}
			}
			else
			{
				System.out.println("The "+x+" turn");
				showBoard(TicTac);
				while(true)
				{
					System.out.println("Enter the Place where you want to place Pawn:");
					int choice=sc.nextInt();
					if(checkAvailability(TicTac,choice-1)==1)
					{
						TicTac[choice-1]=Pawns[0];
						break;
					}
					else
					{
						System.out.println("Entered Position Already filled");
					}
				}
			}
			
			//checking the winning 
			int win=rowWinCheck(TicTac,Pawns[current]);
			if(win==0)
			{
				win=columnWinCheck(TicTac,Pawns[current]);
				if(win==0)
				{
					win=diagnolWinCheck(TicTac,Pawns[current]);
					//if any diagnols are matched then displaying as the user or computer won
					if(win==1)
					{
						showBoard(TicTac);
						if(current==1)
						{
							System.out.println("The Computer won the Match");
							return;
						}
						else
						{
							System.out.println("The"+x+"won the Match");
							return ;
						}
					}
				}
				//if any coloumns are matched then displaying as the user or computer won
				else
				{
					showBoard(TicTac);
					if(current==1)
					{
						System.out.println("The Computer won the Match");
						return ;
					}
					else
					{
						System.out.println("The"+x+"won the Match");
						return ;
					}
				}
			}
			//if any rows are matched then displaying as the user or computer won
			else
			{
				showBoard(TicTac);
				if(current==1)
				{
					System.out.println("The Computer won the Match");
					return ;
				}
				else
				{
					System.out.println("The"+x+"won the Match");
					return ;
				}
			}
			if(current==1)
			{
				current=0;
			}
			else
			{
				current=1;
			}

		}
		//if neither of condition fails then displaying as drawn match
		System.out.println("The Match is Drawn");
		return ;

	}
	public static void main(String[] args) {
	            Scanner sc=new Scanner(System.in);
	            String player=new String();
	            System.out.println("---Enter Player Name:");
	            player=sc.nextLine();
	            char [] Pawns=new char[2];
	            int tosswon=toss(player);
	            Pawns=choosePawn(Pawns);
	            game(player,Pawns,tosswon);
	            sc.close();
	            
	}
}