import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TicTacToePrac {
	static ArrayList<Integer> player1Positions= new ArrayList<Integer>();
	static ArrayList<Integer> player2Positions= new ArrayList<Integer>();
	public static void main(String[] args) {
		char[][] gameBoard = {{' ', '|',' ','|',' '},
								{'-', '+','-','+','-'},
								{' ', '|',' ','|',' '},
								{'-', '+','-','+','-'},
						 		{' ', '|',' ','|',' '}};
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Player1 :");
			int player1Pos = sc.nextInt();
			while(player1Positions.contains(player1Pos) || player2Positions.contains(player1Pos)) {
				System.out.println("Enter Another Pos ! place already occupied");
				player1Pos = sc.nextInt();
			}
			placePiece(gameBoard, player1Pos, "player1");
			printGameBoard(gameBoard);
			String result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			System.out.println("Player 2: ");
			int player2Pos = sc.nextInt();
			while(player2Positions.contains(player2Pos)|| player1Positions.contains(player2Pos)) {
				System.out.println("Enter Another Pos ! place already occupied");
				player2Pos = sc.nextInt();
			}
			placePiece(gameBoard, player2Pos, "player2");
			printGameBoard(gameBoard);
			result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
				}
		}
	public static void printGameBoard(char[][] gameBoard) {
		for(char [] row : gameBoard) {
			for(char r : row) {
				System.out.print(r);
			}
			System.out.println();
		}
	}
	public static void placePiece(char[][] gameBoard,int pos,String user) {
		char symbol =' ';
		if(user.equals("player1")) {
			symbol = 'X';
			player1Positions.add(pos);
		}
		else if(user.equals("player2")){
			symbol= 'O';
			player2Positions.add(pos);

		}
		switch(pos) {
		case 1:
			gameBoard[0][0]=symbol;
			break;
		case 2:
			gameBoard[0][2]=symbol;
			break;
		case 3:
			gameBoard[0][4]=symbol;
			break;
		case 4:
			gameBoard[2][0]=symbol;
			break;
		case 5:
			gameBoard[2][2]=symbol;
			break;
		case 6:
			gameBoard[2][4]=symbol;
			break;
		case 7:
			gameBoard[4][0]=symbol;
			break;
		case 8:
			gameBoard[4][2]=symbol;
			break;
		case 9:
				gameBoard[4][4]=symbol;
				break;
		default:
				break;
		
		}
	}
	public static String checkWinner() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(1,4,7);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		List<List> list = new  ArrayList<List>();
		list.add(topRow);	
		list.add(midRow);
		list.add(botRow);
		list.add(leftCol);
		list.add(midCol);
		list.add(rightCol);
		list.add(cross1);
		list.add(cross2);
		for(List l: list) {
			if(player1Positions.containsAll(l)) {
//				System.out.println("Player 1 Wins");
				return "player 1 Wins";
			}
			else if(player2Positions.containsAll(l)) {
				return "player 2 Wins";
			}
			else if(player1Positions.size()+player2Positions.size()==9) {
				return "Cat!";
			}
		}
		return "";



	}

}
