import java.util.Scanner;
public class Board
	{

		public Square[][] board = new Square[9][9];
		
		public Board(){
			for(int row = 0; row < board.length; row++){
				for(int col = 0; col < board[row].length; col++){

					board[row][col] = new Square(-1);
					
				}
			}
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
	
		
		public static void print(Board board){
			
			for(int row = 0; row < 9; row++){
				for(int i=0; i < 9; i +=3){
					for(int j = 0; j < 3; j++){
						
						int value =board.getSquare(row, i+j).getValue();
						if(value != -1){
							System.out.print(value);
						}else
							System.out.print(" ");
						
					}
					if(i!= 6){
						System.out.print("|");
					}
					
				}
				System.out.println();
				
				if(row != 8 && row % 3 == 2){
					System.out.println("---+---+---");
				}
				
			}
			
			
			System.out.println();
			
			
			
		}
		
		
		public static Board importFromText(){
			
		 
			Scanner userString = new Scanner(System.in);
			
			Board board = new Board();
			String text = userString.nextLine();
			
			for(int i = 0; i < text.length(); i++){
				String currentChar = text.substring(i,i+1);
					if(!currentChar.equals(" ")){
						
						int col = i % 9;
						int row = (int)(((double)i / 81.0) * 9);
						
						String[] numbers = {"1","2","3","4","5","6","7","8","9"};
						int currentInt = -1;
						
						for(int j = 0; j < 9; j++){
							if(numbers[j].equals(currentChar)){
								currentInt = j+1;
							}
							
							
						}
						
						 board.getSquare(row, col).setValue(currentInt);
					}
				
				
			}
			
			return board;
		}
		
		
		
	}
