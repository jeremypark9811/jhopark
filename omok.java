package omok;
import java.util.Scanner;
public class omok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		char[][] board = new char[10][10];
		char original = '*';
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				board[i][j] = original;
			}
		}
		//p1 = O 	p2 = X
		int run = 0;
		while(run == 0) {
			System.out.println("----------p1----------");
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					System.out.print(board[i][j] + "\t");
				}
				System.out.println("\n");
			}
			System.out.println("x-coordinate");
			int x_p1 = scan.nextInt();
			System.out.println("y_coordinate");
			int y_p1 = scan.nextInt();
			
			if(board[y_p1][x_p1] == original) {
				board[y_p1][x_p1] = 'O';
			}
			//horizontal check
			for(int i = 0; i<10; i++) {
				int count = 0;
				for(int j = 0; j<10; j++) {
					if(j > 0) {
						if(board[i][j] == 'O' && board[i][j-1] == 'O') {
							if(j == 1) {
								count = 1;
							}
							count = count+1;
						}else {
							count = 0;
						}
					}
					if(count == 5) {
						run = 1;
					}
				}
			}
			//vertical check
			for(int i = 0; i<10; i++) {
				int count = 0;
				for(int j = 0; j<10; j++) {
					if(j > 0) {
						if(board[j][i] == 'O' && board[j-1][i] == 'O') {
							if(j == 1) {
								count = 1;
							}
							count = count+1;
						}else {
							count = 0;
						}
					}
					if(count == 5) {
						run = 1;
					}
				}
			}
			//diagonal check
			int count_p1 = 0;
			for(int i = 1; i<10; i++) {
				if(board[i][i] == 'O' && board[i-1][i-1] == 'O') {
					if(i == 1) {
						count_p1 = 1;
					}
					count_p1 = count_p1 + 1;
				}else if(board[i][i] != 'O') {
					count_p1 = 0;
				}
				if(count_p1 == 5) {
					run = 1;
				}
			}
			
			count_p1 = 0;
			for(int i = 1; i<10; i++) {
				if(board[i][9-i] == 'O' && board[i-1][9-i+1] == 'O') {
					if(i == 1) {
						count_p1 = 1;
					}
					count_p1 = count_p1 + 1;
				}else if(board[i][9-i] != 'O') {
					count_p1 = 0;
				}
				if(count_p1 == 5) {
					run = 1;
				}
			}
			
			System.out.println("----------p2----------");
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					System.out.print(board[i][j] + "\t");
				}
				System.out.println("\n");
			}
			System.out.println("x-coordinate");
			int x_p2 = scan.nextInt();
			System.out.println("y_coordinate");
			int y_p2 = scan.nextInt();
			
			if(board[y_p2][x_p2] == original) {
				board[y_p2][x_p2] = 'X';
			}
			//horizontal check
			for(int i = 0; i<10; i++) {
				int count = 0;
				for(int j = 0; j<10; j++) {
					if(j > 0) {
						if(board[i][j] == 'X' && board[i][j-1] == 'X') {
							if(j == 1) {
								count = 1;
							}
							count = count+1;
						}else {
							count = 0;
						}
					}
					if(count == 5) {
						run = 2;
					}
				}
			}
			//vertical check
			for(int i = 0; i<10; i++) {
				int count = 0;
				for(int j = 0; j<10; j++) {
					if(j > 0) {
						if(board[j][i] == 'X' && board[j-1][i] == 'X') {
							if(j == 1) {
								count = 1;
							}
							count = count+1;
						}else {
							count = 0;
						}
					}
					if(count == 5) {
						run = 2;
					}
				}
			}
			//diagonal check
			int count_p2 = 0;
			for(int i = 1; i<10; i++) {
				if(board[i][i] == 'X' && board[i-1][i-1] == 'X') {
					if(i == 1) {
						count_p2 = 1;
					}
					count_p2 = count_p2 + 1;
				}else if(board[i][i] != 'X') {
					count_p2 = 0;
				}
				if(count_p2 == 5) {
					run = 2;
				}
			}
			
			count_p2 = 0;
			for(int i = 1; i<10; i++) {
				if(board[i][9-i] == 'X' && board[i-1][9-i+1] == 'X') {
					if(i == 1) {
						count_p2 = 1;
					}
					count_p2 = count_p2 + 1;
				}else if(board[i][9-i] != 'X') {
					count_p2 = 0;
				}
				if(count_p2 == 5) {
					run = 2;
				}
			}
						
		}
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
		if(run == 1) {
			System.out.println("Player 1 wins!!");
		}else if(run == 2) {
			System.out.println("Player 2 wins!!");
		}
		
	}

}
