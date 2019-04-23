package main;

import java.io.IOException;

public class Vida {
	static int min = 0;
	static int maxX = 51;
	static int maxY = 51;
	static final String full = " o ";
	static final String empty = "   ";
	static String[][] board = new String[maxX][maxY];
	static String[][] boardB = new String[maxX][maxY];
	static int[][] boardC = new int[maxX][maxY];

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		generateBoard();
//		clonar();
		impresion();
	}

	public static void impresion() throws InterruptedException, IOException {
		int cont = 0;
		while (true) {
			System.out.println("Turno: " + cont);
			printBoard();
//			mover();
			Thread.sleep(200);
			check();
//			clonar();
			cont++;
		}
	}

	public static void cleanConsole() throws InterruptedException, IOException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

	/**
	 * Check if the 8 sourring cells are alive. if there are 2 or 3 surrounding =
	 * new cell is created if there are not surrounding = Cell dies if there are
	 * more than 3 cells = Cell dies
	 * 
	 * @param x x position of our cell
	 * @param y y position of our cell
	 * @return status 1: Keeps the same state 2. Born 3. Dies
	 */
	public static void checkSurrounding(int x, int y) {
		int fullCont = 0;
//		int status = 0;
		for (int BusqX = x - 1; BusqX <= x + 1; BusqX++) {
			for (int BusqY = y - 1; BusqY <= y + 1; BusqY++) {
				if (board[BusqX][BusqY] == full) { // && BusqX>=0 && BusqX<=20 && BusqY>=0 && BusqY<=20 &&
					fullCont++;
					// System.out.println(fullCont);
				}
			}
		}
		if (board[x][y] == full) {
			fullCont--;
		}
		boardC[x][y] = fullCont;
	}

	public static void generateBoard() {
		for (int contx = min; contx < maxX; contx++) {
			for (int conty = min; conty < maxY; conty++) {
				board[contx][conty] = empty;
			}
		}
		board[23][23] = full;
		board[23][24] = full;
		board[24][24] = full;
		board[25][24] = full;
		board[24][25] = full;
		
//		board[2][2] = full;
//		board[2][3] = full;
//		board[3][3] = full;
//		board[4][3] = full;
//		board[3][4] = full;
//		
//		board[12][2] = full;
//		board[12][3] = full;
//		board[13][3] = full;
//		board[14][3] = full;
//		board[13][4] = full;
//		
//		board[2][12] = full;
//		board[2][13] = full;
//		board[3][13] = full;
//		board[4][13] = full;
//		board[3][12] = full;
		System.out.println("Generated");
	}

	public static void printBoard() {
//		System.out.println("BOARD A");
		for (int contx = min+1; contx < maxX-1; contx++) {
			for (int conty = min+1; conty < maxY-1; conty++) {
				System.out.print(board[contx][conty]);
				checkSurrounding(contx, conty);
			}
			System.out.println("");
		}
	}

//	public static void mover() {
//		for (int contx = 1; contx < maxX-1; contx++) {
//			for (int conty = 1; conty < maxY-1; conty++) {
//				switch (checkSurrounding(contx, conty)) { //1: Keeps the same state 2. Born 3. Dies
//				case 2:
//					board[contx][conty] = full;
//				default:
//				case 3:
//					board[contx][conty] = empty;
//					break;
//				}
//			}
//		}
//	}
//	public static void clonar(){
//		System.out.println("BOARD B");
//		for (int contx = 0; contx < maxX; contx++) {
//			for (int conty = 0; conty < maxY; conty++) {
//				boardB[contx][conty]=board[contx][conty];
//				System.out.print(boardB[contx][conty]);
//			}
//			System.out.println("");
//		}
//	}
	public static void check() {
//		System.out.println("BOARD C");
		for (int contx = min+1; contx < maxX-1; contx++) {
			for (int conty = min+1; conty < maxY-1; conty++) {
				// boardB[contx][conty]=board[contx][conty];
//				System.out.print("[");
//				if(boardC[contx][conty]>0) {
//					System.out.print(boardC[contx][conty]);
//				}
//				else {
//					System.out.print(" ");
//				}
//				System.out.print("]");
				switch (boardC[contx][conty]) { // 1: Keeps the same state 2. Born 3. Dies
				case 2:
				break;
				case 3:
					board[contx][conty] = full;
					break;
				default:
					board[contx][conty] = empty;
					break;
				}
			}
			System.out.println("");
		}
	}
}
