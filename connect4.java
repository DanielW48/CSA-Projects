import java.util.Arrays;
import java.util.Scanner;

public class connect4 {
	static int lastR, lastC;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[8][8];
		for(int i = 0; i < board.length; i++) Arrays.fill(board[i], ' ');
		char p1 = 'X', p2 = 'O';
		int turn = 0;
		while(true){
			printBoard(board);
			
			if(turn == 0) System.out.println("Player 1 is up!");
			else if(turn == 1) System.out.println("Player 2 is up!");
			System.out.println("Please enter a collumn to play your piece.");
			int xInput = sc.nextInt() - 1;
			
			char charInput = p1;
			if(turn == 1) charInput = p2;
			
			if(!placePiece(board, xInput, charInput)){
				System.out.println("Sorry, that's an invalid move.");
				continue;
			}
			
			
			int winner = checkWinner(board, lastR, lastC, charInput);
			if(winner == 0){
				System.out.print("Congratulations, player ");
				if(turn == 0) System.out.print("1! " + p1);
				else System.out.print("2! " + p2);
				System.out.println(" wins!");
				printBoard(board);
				break;
			}
			else if(winner == 2){
				System.out.println("Nobody wins!");
				break;
			}
			
			
			if(turn == 0) turn = 1;
			else turn = 0;
		}
		
		sc.close();
	}



	static int checkWinner(char[][] in, int rIn, int cIn, char pIn){
		for(int i = rIn - 3; i <= rIn; i++){
			if(i < 0 || i + 3 >= in.length) continue;
			if(in[i][cIn] == pIn && in[i + 1][cIn] == pIn && in[i + 2][cIn] == pIn && in[i + 3][cIn] == pIn) return 0;
		}
		for(int i = cIn - 3; i <= cIn; i++){
			if(i < 0 || i + 3 >= in[0].length) continue;
			if(in[rIn][i] == pIn && in[rIn][i + 1] == pIn && in[rIn][i + 2] == pIn && in[rIn][i + 3] == pIn) return 0;
		}
		for(int i = -3; i <= 0; i++){
			if(rIn + i < 0 || rIn + i + 3 >= in.length || cIn + i < 0 || cIn + i + 3 >= in[0].length) continue;
			if(in[rIn + i][cIn + i] == pIn && in[rIn + i + 1][cIn + i + 1] == pIn && in[rIn + i + 2][cIn + i + 2] == pIn && in[rIn + i + 3][cIn + i + 3] == pIn) return 0;
		}
		for(int i = -3; i <= 0; i++){
			if(rIn - i >= in.length || rIn - (i + 3) < 0 || cIn + i < 0 || cIn + i + 3 >= in[0].length) continue;
			if(in[rIn - i][cIn + i] == pIn && in[rIn - (i + 1)][cIn + i + 1] == pIn && in[rIn - (i + 2)][cIn + i + 2] == pIn && in[rIn - (i + 3)][cIn + i + 3] == pIn) return 0;
		}
		
		for(int i = 0; i < in[0].length; i++) if(in[0][i] == ' ') return 1;
		
		return 2;
	}
	static boolean placePiece(char[][] in, int xIn, char pieceIn){
		if(xIn < 0 || xIn >= in[0].length || in[0][xIn] != ' ') return false;
		for(int i = 0; i < in.length; i++){
			if(i == in.length - 1 || in[i + 1][xIn] != ' '){
				in[i][xIn] = pieceIn;
				lastR = i;
				lastC = xIn;
				return true;
			}
		}
		return false;
	}
	static void printBoard(char[][] in){
		String nums = " ";
		for(int i = 0; i < in[0].length; i++) nums += (i + 1) + " ";
		System.out.println(nums);
		String line = "-";
		for(int i = 0; i < in[0].length; i++) line += "--";
		System.out.println(line);
		for(int i = 0; i < in.length; i++){
			System.out.print("|");
			for(int j = 0; j < in[0].length; j++){
				System.out.print(in[i][j] + "|");
			}
			System.out.println("\n" + line);
		}
	}
}
