import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

// Models a TicTacToe game
public class TicTacToeGame {
	static char[][] gameBoard = new char[][] { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' },
			{ ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

	static boolean flag = false;

	static ArrayList<Integer> playerMoves = new ArrayList<Integer>();
	static ArrayList<Integer> computerMoves = new ArrayList<Integer>();

	public static void main(String[] args) {
		// printBoard();
		int count = 0;
		int move = -1;
		int computerMove = -1;

		System.out.println("Hello! Welcome to the TicTacToe game!");
		System.out.println();
		while (true) {
			System.out.println("Please select a number between 1 and 9 to make a move");
			System.out.println("Make sure to not take spot/number that is already taken!");

			Scanner scnr = new Scanner(System.in);
			move = scnr.nextInt();

			while (playerMoves.contains(move) || computerMoves.contains(move)) {
				System.out.println("Invalid move! Chose again");
				move = scnr.nextInt();
			}
			playerMoves.add(move);
			playMove("Player", move);
			// printBoard();
			// count++;

			if (gameBoard[0][0] == ' ' || gameBoard[0][2] == ' ' || gameBoard[0][4] == ' ' || gameBoard[2][0] == ' '
					|| gameBoard[2][2] == ' ' || gameBoard[2][4] == ' ' || gameBoard[4][0] == ' '
					|| gameBoard[4][2] == ' ' || gameBoard[4][4] == ' ') {
				Random rand = new Random();
				computerMove = rand.nextInt(9) + 1;

				while (playerMoves.contains(computerMove) || computerMoves.contains(computerMove)) {
					computerMove = rand.nextInt(9) + 1;
				}
				computerMoves.add(computerMove);
				// if (count < 8) {
				playMove("Computer", computerMove);
				// printBoard();
				// count++;
				// }
			}
			printBoard();
			// printBoard();
			// Need to make sure the computer does not play on an already occupied spot and
			// make sure that we dont play on an occupied spot as well.

			// Need to add winning conditions
			if (WinningConditions() == true) {
				// System.out.println("Congratulation! You won the game!");
				//printBoard();
				break;
			}

			if (losingConditions() == true) {
				// System.out.println("Sorry :( You lost the game. Better luck next time!");
				//printBoard();
				break;
			}

			// Accounting for a draw condition
			// System.out.println(count);
			if (gameBoard[0][0] != ' ' && gameBoard[0][2] != ' ' && gameBoard[0][4] != ' ' && gameBoard[2][0] != ' '
					&& gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ' && gameBoard[4][0] != ' '
					&& gameBoard[4][2] != ' ' && gameBoard[4][4] != ' ') {
				System.out.println("It is a draw!");
				break;

			}
			// if (count == 9) {
			// System.out.println("It is a draw!");
			// break;
			// }

		}
	}

	public static void printBoard() {
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(gameBoard[j]);
				System.out.println();
			}
		}
	}

	public static void playMove(String user, int position) {
		char Symbol = 'c';
		if (user.equals("Player")) {
			Symbol = 'X';
		}

		if (user.equals("Computer")) {
			Symbol = 'O';
		}

		if (position == 1) {
			gameBoard[0][0] = Symbol;
		}

		if (position == 2) {
			gameBoard[0][2] = Symbol;
		}

		if (position == 3) {
			gameBoard[0][4] = Symbol;
		}

		if (position == 4) {
			gameBoard[2][0] = Symbol;
		}

		if (position == 5) {
			gameBoard[2][2] = Symbol;
		}

		if (position == 6) {
			gameBoard[2][4] = Symbol;
		}

		if (position == 7) {
			gameBoard[4][0] = Symbol;
		}

		if (position == 8) {
			gameBoard[4][2] = Symbol;
		}

		if (position == 9) {
			gameBoard[4][4] = Symbol;
		}
		// printBoard();
	}

	public static boolean WinningConditions() {
		// These are the winning conditions

		// Horizontal
		if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}

		if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}

		if (gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}
		// Vertical down
		if (gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}

		if (gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}

		if (gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}

		// Cross
		if (gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}

		if (gameBoard[4][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[0][4] == 'X') {
			System.out.println("Congratulations! You won the game");
			flag = true;
			return true;
		}
		return false;
	}

	public static boolean losingConditions() {
		if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}

		if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}

		if (gameBoard[4][0] == 'O' && gameBoard[4][2] == 'O' && gameBoard[4][4] == 'O') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}
		// Vertical down
		if (gameBoard[0][0] == 'O' && gameBoard[2][0] == 'O' && gameBoard[4][0] == 'O') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}

		if (gameBoard[0][2] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][2] == 'O') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}

		if (gameBoard[0][4] == 'O' && gameBoard[2][4] == 'O' && gameBoard[4][4] == 'O') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}

		// Cross
		if (gameBoard[0][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][4] == 'O') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}

		if (gameBoard[4][0] == 'O' && gameBoard[2][2] == '0' && gameBoard[0][4] == '0') {
			System.out.println("Sorry! You lost the game. Better luck next time :)");
			flag = true;
			return true;
		}
		return false;
	}
}
