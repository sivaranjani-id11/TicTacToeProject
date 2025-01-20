package com.tap.play;
import java.util.Random;
import java.util.Scanner;

  class TicTacToe
{
	 static char[][] board;
	
	
	 public TicTacToe()
	{
		board=new char[3][3];
		initBoard();
	}
	
	 static void initBoard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	
	
	
	 static void dispBoard()
	{
		System.out.println("-------------");
		
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j] + " | ");
				
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	 static void placeMark(int row,int col,char mark)
	{
		board[row][col]=mark;
	}
	
	 static public boolean checkColwin()
	{
		for(int j=0;j<=2;j++)
		{
			if(board[0][j]!=' ' && board[0][j]==board[1][j]  && board[1][j]==board[2][j] )
			{
				return true;
			}
		}
		return false;
	}
	
		 static public  boolean checkRowWin()
		{
			for(int i=0;i<=2;i++)
			{
				if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
				{
					return true;
				}
			}
			return false;
		}
	
		
		 static public boolean diagonalWin()
		{
			if(board[0][0]!=' ' && board[0][0]==board[1][1] &&  board[1][1]==board[2][2]  ||  board[0][2]==' ' && board[0][2]==board[1][1] &&  board[1][1]==board[2][0] )
			{
				return true;
			}
			return false;
			
		}
		 
		public  static boolean checkDraw()
		 {
			 for(int i=0;i<=2;i++)
			 {
				 for(int j=0;j<=2;j++)
				 {
					 if(board[i][j]==' ')
					 {
						 return false;
					 }
				 }
			 }
			 return true;
		 }
		
	
}

abstract class Player
{
	
	String name;
	char mark;
	
	 abstract void makeMove();
	 
	 boolean isValidMove(int row,int col)
	 {
		 if(row>=0 && row<=2 && col>=0 && col<=2)
		 {
			 if(TicTacToe.board[row][col]==' ')
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 
	
}


class HumanPlayer extends Player
{
	
	HumanPlayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	
	void makeMove()
	{
		Scanner scan=new Scanner(System.in);
		int row;
		int col;
		
		do
		{
			System.out.println("Enter the row and Column: ");
			row=scan.nextInt();
			col=scan.nextInt();
			
		}
		while(!isValidMove(row,col));
		
		TicTacToe.placeMark(row, col, mark);
	}
}
class AIPlayer extends Player
{
	
	AIPlayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	
	void makeMove()
	{
		Scanner scan=new Scanner(System.in);
		int row;
		int col;
		
		do
		{
			Random r=new Random();
			row=r.nextInt();
			col=r.nextInt();
			
			
			
		}
		while(!isValidMove(row,col));
		
		TicTacToe.placeMark(row, col, mark);
	}
}







class AIPLAYER
{
	
}

public class LaunchGame {
	
	public static void main(String[] args) {
		
		TicTacToe t=new TicTacToe();
		
		
		
		
		
	}

}



/*t.dispBoard();
t.placeMark(0, 0,'X');
t.placeMark(1, 1,'X');
t.placeMark(2,2,'X');
t.placeMark(0, 0, 'O');
t.placeMark(1, 0, 'X');
t.placeMark(2,0,'X');
t.placeMark(0, 1, 'O');
t.placeMark(0, 2, 'O');

t.dispBoard();
boolean row=t.checkRowWin();

boolean col=t.checkColwin();
boolean dignl=t.diagonalWin();

System.out.println(row);
System.out.println(col);
System.out.println(dignl);
*/

