package bingo;
import java.util.Random;
import java.util.Scanner;
public class Bingo_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int size = 5;
		int[][] board_p1 = new int[size][size];
		int[][] check_p1 = new int[size][size];
		
		int[][] board_p2 = new int[size][size];
		int[][] check_p2 = new int[size][size];
		
		int[] mix_p1 = new int[size*size];
		int[] mix_p2 = new int[size*size];
		
		int range = 50;
		for(int i = 0; i<mix_p1.length; i++) {
			mix_p1[i] = ran.nextInt(range)+1;
			if(i>0) {
				for(int j = 0; j<i; j++) {
					if(mix_p1[j] == mix_p1[i]) {
						i = i-1;
					}
				}
			}
		}
		for(int i = 0; i<mix_p2.length; i++) {
			mix_p2[i] = ran.nextInt(range)+1;
			if(i>0) {
				for(int j = 0; j<i; j++) {
					if(mix_p2[j] == mix_p2[i]) {
						i = i-1;
					}
				}
			}
		}
		
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				board_p1[i][j] = mix_p1[i*5+j];
				check_p1[i][j] = 0;
				board_p2[i][j] = mix_p2[i*5+j];
				check_p2[i][j] = 0;
			}
		}
		
		//p1 win = 1 p2 win =2
		int run = 0;
		while(run == 0) {
			System.out.println("-------------Game Start [p1]-------------");
			for(int i = 0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					if(check_p1[i][j] == 1) {
						System.out.print("o\t");
					}else {
						System.out.print(board_p1[i][j] + "\t");
					}
				}
				System.out.println();
				System.out.println();
			}
			System.out.println("xÁÂÇ¥");
			int xloc_p1 = scan.nextInt();
			System.out.println("yÁÂÇ¥");
			int yloc_p1 = scan.nextInt();
			
			if(check_p1[yloc_p1][xloc_p1] == 0) {
				check_p1[yloc_p1][xloc_p1] = 1;
			}
			int num = board_p1[yloc_p1][xloc_p1];
			for(int i = 0; i<5; i++) {
				for(int j = 0; j<5; j++) {
					if(board_p2[i][j] == num) {
						check_p2[i][j] = 1;
					}	
				}
			}
			System.out.println("-------------Game Start [p2]-------------");
			for(int i = 0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					if(check_p2[i][j] == 1) {
						System.out.print("x\t");
					}else {
						System.out.print(board_p2[i][j] + "\t");
					}
				}
				System.out.println();
				System.out.println();
			}
			System.out.println("xÁÂÇ¥");
			int xloc_p2 = scan.nextInt();
			System.out.println("yÁÂÇ¥");
			int yloc_p2 = scan.nextInt();
			
			if(check_p2[yloc_p2][xloc_p2] == 0) {
				check_p2[yloc_p2][xloc_p2] = 1;
			}
			num = board_p2[yloc_p2][xloc_p2];
			System.out.println("num = " + num);
			for(int i = 0; i<5; i++) {
				for(int j = 0; j<5; j++) {
					if(board_p1[i][j] == num) {
						check_p1[i][j] = 1;
					}	
				}
			}
			//horizontal 
			for(int i = 0; i<5; i++) {
				int count_p1 = 0;
				int count_p2 = 0;
				for(int j = 0; j<5; j++) {
					if(check_p1[i][j] == 1) {
						count_p1 = count_p1 + 1;
						if(count_p1 == 5) {
							run = 1;
						}
					}
					if(check_p2[i][j] == 1) {
						count_p2 = count_p2+1;
						if(count_p2==5) {
							run = 2;
						}
					}
				}
			}
			//vertical
			for(int i = 0; i<5; i++) {
				int count_p1 = 0;
				int count_p2 = 0;
				for(int j = 0; j<5; j++) {
					if(check_p1[j][i]==1) {
						count_p1 = count_p1+1;
						if(count_p1 == 5) {
							run = 1;
						}
					}
					if(check_p2[j][i]==1) {
						count_p2 = count_p2+1;
						if(count_p2 == 5) {
							run = 2;
						}
					}
				}		
			}
			//diagonal
			int count_p1 = 0;
			int count_p2 = 0;
			for(int i = 0; i<5; i++) {
				if(check_p1[i][i] == 1) {
					count_p1 = count_p1 + 1;
				}
				if(count_p1 == 5) {
					run = 1;
				}
				if(check_p2[i][i] == 1) {
					count_p2 = count_p2 +1;
				}
				if(count_p2 == 5) {
					run = 2;
				}
			}
			count_p1 = 0;
			count_p2 = 0;
			for(int i = 0; i<5; i++) {
				if(check_p1[i][4-i] == 1) {
					count_p1 = count_p1 + 1;
				}
				if(count_p1 == 5) {
					run = 1;
				}
				if(check_p2[i][4-i] == 1) {
					count_p2 = count_p2 + 1;
				}
				if(count_p2 == 5) {
					run = 2;
				}
			}
			
		
		}
		if(run == 1) {
			System.out.println("Player 1 Win");
		}else if(run == 2) {
			System.out.println("Player 2 Win");
		}
	}

}
