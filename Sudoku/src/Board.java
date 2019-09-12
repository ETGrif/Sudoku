
public class Board
	{

		public Square[][] board = new Square[9][9];
		
		public Board(){
			
		}
		
		public Board(int[][] values){
			//if given values, fill
			for(int row = 0; row < board.length; row++){
				for(int col = 0; col < board[row].length; col++){

					board[row][col] = new Square(values[row][col]);
					
				}
			}
			
			
			
		}

		
		public Square[][] getBoard()
			{
				return board;
			}
		

		public void setBoard(Square[][] board)
			{
				this.board = board;
			}
		
		public Square getSquare(int row, int col){
			return board[row][col];
			
		}
	
		
		
		
		
		
		
		
	}
