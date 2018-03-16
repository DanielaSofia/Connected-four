import java.util.*;

class Board{

	public int lines = 7;
	public int columns = 6;
	public int[][] board = new int[7][6];


	// clean the initial matrix
	public void BlankBoard(int [][] board){

		for (int i=0;i<lines;i++) {
			for (int j=0;j<columns;j++ ) {
				board[i][j]=0;
			}
		}
	}

	public void PrintBoard(int[][] board){

		for(int i=0;i<lines;i++){
            for(int j=0;j<columns;j++){
                if(board[i][j] == 0)
                    System.out.print("_  ");
                else
                    System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
        
        for(int i=0;i<columns;i++)
            System.out.print("*  ");
        System.out.println();
        
        for(int i=0;i<columns;i++)
            System.out.print(i+"  ");
        System.out.println();

	}

	public boolean CheckMove(int[][] board, int col){
		if(col>0 && col<6){
			for (int i=lines-1;i>0;i--) {
				if(board[i][col]==0){
					return true;
				}
			}
		}
		return false;
	}

	public int[][] MakeMove(int[][] board, int col,int player){

		for (int i=lines-1;i>0;i--) {
			if(board[i][col]==0){
				board[i][col]=player;
				break;
			}
		}
		return board;
	}


}







public class ConnectedFour{

	
	public static void main(String [] args){

		Scanner in = new Scanner(System.in);
		Board b = new Board();
		// selected column
		int scol=0;

		b.BlankBoard(b.board);
		b.PrintBoard(b.board);

		while(true){

			System.out.println("Player1 play!");

			// select column
			scol=in.nextInt();
			
				while(!b.CheckMove(b.board,scol)){
					
					System.out.println("Player1 play valid!");
					scol=in.nextInt();
				}

				b.board=b.MakeMove(b.board,scol,1);
				b.PrintBoard(b.board);

			System.out.println("Player2 play!");

			// select column
			scol=in.nextInt();
			
				while(!b.CheckMove(b.board,scol)){
					
					System.out.println("Player2 play valid!");
					scol=in.nextInt();
				}

				b.board=b.MakeMove(b.board,scol,2);
				b.PrintBoard(b.board);
			
			
		}
	}
}