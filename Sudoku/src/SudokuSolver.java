
public class SudokuSolver
	{

		public static void main(String[] args)
			{

				int[][] testBoardValues =
					{
							{ 8, 7, 6, 9, -1, -1, -1, -1, -1 },
							{ -1, 1, -1, -1, -1, 6, -1, -1, -1 },
							{ -1, 4, -1, 3, -1, 5, 8, -1, -1 },
							{ 4, -1, -1, -1, -1, -1, 2, 1, -1 },
							{ -1, 9, -1, 5, -1, -1, -1, -1, -1 },
							{ -1, 5, -1, -1, 4, -1, 3, -1, 6 },
							{ -1, 2, 9, -1, -1, -1, -1, -1, 8 },
							{ -1, -1, 4, 6, 9, -1, 1, 7, 3 },
							{ -1, -1, -1, -1, -1, 1, -1, -1, 4 } };

				Board board = new Board(testBoardValues);

				for (int row = 0; row < 9; row++)
					{
						for (int col = 0; col < 9; col++)
							{
								int temp = board.getSquare(row, col).getValue();
								if (temp != -1)
									{
										System.out.print(temp);
									}
								else
									{
										System.out.print(" ");
									}

							}
						System.out.println();
					}

			}

		// trace algorithm
		//// loop till you can move trough the whole board without making an
		//// action
		////// loop for every possible value-remove possible values that can be
		////// ruled out
		//////// trace row
		//////// trace col
		//////// trace 3x3
		////// if there is only one possible, set to value

		public static void solve(Board board)
			{

				int consecutiveActions = 0;
				while(consecutiveActions < 81){
					
					for(int row = 0; row < 9; row++){
						for(int col = 0; col < 9; col++){
							
							boolean didAction = false;
							boolean[] possibleValues = board.getSquare(row, col).getPossibleValues();
							
							//for each number
							for(int i = 0; i < possible){
								
							}
							
							
							
							
							
						}
					}
					
					
					
					
					
				}
				
				
				
			}

	}
