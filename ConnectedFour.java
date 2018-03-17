import java.util.*;

class Board{

	public int lines = 6;
	public int columns = 7;
	public int[][] board = new int[6][7];


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
		if(col>=0 && col<7){
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

	public int Win(int[][] board){

		// Vertical
		int p1=0;
		int p2=0;
		int j=columns-1;
		while(j>=0){
			for (int i=lines-1;i>0;i--) {
				if(board[i][j]==1)
					p1++;
				if(board[i][j]==2)
					p2++;

				
			}
			if(p1==4) return 1;
			if(p2==4) return 2;
			p1=0;
			p2=0;
			j--;
		}
		
		p1=0;
		p2=0;

		// Horizontal
		j=lines-1;
		while(j>=0){
			for (int i=columns-1;i>0;i--) {
				if(board[j][i]==1)
					p1++;
				if(board[j][i]==2)
					p2++;

				
			}
			if(p1==4) return 1;
			if(p2==4) return 2;
			p1=0;
			p2=0;
			j--;
		}

		/*// Diagonal
		p1=0;
		p2=0;
        	




        if(p1==4) return 1;
		if(p2==4) return 2;
		p1=0;
		p2=0;*/

		
	return 0;

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
			if(b.Win(b.board) == 1){
				b.PrintBoard(b.board);
				System.out.println("Player 1 Wins !!");
				System.exit(0);
				
			}
			b.PrintBoard(b.board);

			System.out.println("Player2 play!");

			// select column
			scol=in.nextInt();
			
			while(!b.CheckMove(b.board,scol)){
			
				System.out.println("Player2 play valid!");
				scol=in.nextInt();
			}

			b.board=b.MakeMove(b.board,scol,2);
			if(b.Win(b.board) == 2){
				b.PrintBoard(b.board);
				System.out.println("Player 2 Wins !!");
				System.exit(0);
				
			}
			b.PrintBoard(b.board);

			
			
			
		}
	}
}