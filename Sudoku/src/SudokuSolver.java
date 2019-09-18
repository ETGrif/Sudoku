import sun.util.resources.ar.CurrencyNames_ar_TN;

public class SudokuSolver
	{

		public static Board solvedBoard;
		
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
				
				// medium
				// |  92  7         6  659138 26 7    35 2473  1    65  9  7      6 5 86    18  9 37 
				// Hard
				// | 7 3 5    6 7 45    4 2 6   1     6  52 3   9   5     7   8 4     6   7   19    8			
				
				
				

//				Board board = new Board(testBoardValues);
				
				
				System.out.println("Input board:");
				Board board = Board.importFromText();

				Board.print(board);
				
				
				
				
//				//print
//				for (int row = 0; row < 9; row++)
//					{
//						for (int col = 0; col < 9; col++)
//							{
//								int temp = board.getSquare(row, col).getValue();
//								if (temp != -1)
//									{
//										System.out.print(temp);
//									}
//								else
//									{
//										System.out.print(" ");
//									}
//
//							}
//						System.out.println();
//					}
				
				solve(board);
				
				Board.print(board);
				
				solvedBoard = board;
				Square.info(0, 4);
				
				
				

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

				int consecutiveActions = 1;
				while (consecutiveActions !=0)
					{
						System.out.println("running again! consecutiveActions = "+consecutiveActions);

						consecutiveActions=0;

						for (int row = 0; row < 9; row++)
							{
							for (int col = 0; col < 9; col++)
									{

										if (board.getSquare(row, col).getValue()== -1)
											{
//												System.out.println("Currently tracing: ("+row+", "+col+")");
												Square currentSquare = board.getSquare(row, col);
												boolean didAction = false;
												boolean[] possibleValues =currentSquare
														.getPossibleValues();
												
												
												
												
												// for each possible number
												for (int i = 0; i < 9; i++)
													{
														//test prints all the possible values:
//														System.out.println(possibleValues[i]);
														if (possibleValues[i])
															{
																// trace row
																for (int traceCol = 0; traceCol < 9; traceCol++)
																	{
																		if (board.getSquare(row, traceCol).getValue() == (i + 1))
																			{
																				currentSquare
																						.setPossibleValue(false, i);
																				didAction = true;
																				

																			}

																	}

																// trace col
																for (int traceRow = 0; traceRow < 9; traceRow++)
																	{
																		if (board.getSquare(traceRow, col)
																				.getValue() == (i + 1))
																			{
																				currentSquare
																						.setPossibleValue(false, i);
																				didAction = true;
																			}

																	}

																//trace box
																Square[][] box = getBox(board, row, col);

																for(int boxRow = 0; boxRow < 3;boxRow++){
																	for(int boxCol = 0; boxCol < 3; boxCol++){
																		
																		if (box[boxRow][boxCol]
																				.getValue() == (i + 1))
																			{
																				currentSquare
																						.setPossibleValue(false, i);
																				didAction = true;
																			}
																		
																		
																	}
																}
																
																
															}

													}

												//count up the action counter
												if (didAction)
													{
														consecutiveActions++;
													}

												//mark permanent values
												// if there is only one possible value for the square
												int numberOfPossibleValues = 0;
												int mostRecentPV = -1;
												for(int i = 0; i <9; i++){
													if(possibleValues[i]){
														numberOfPossibleValues++;
														mostRecentPV = i +1;
													}
												}
												if(numberOfPossibleValues == 1){
													currentSquare.setValue(mostRecentPV);
												}
												
												if(currentSquare.getValue()==-1){
												 //if it is the only possible value for this:
												//for each possible number
												for(int i = 0; i <9; i++){
													//in rowS
//													System.out.println("testA:"+row + col);
													if(possibleValues[i]){
//														System.out.println("testB"+i);
														//check if only in row
														int totalOccurances = 0;
														for(int scanCol = 0; scanCol < 9; scanCol++){
//															System.out.println("testC");
															if(board.getSquare(row, scanCol).getPossibleValues()[i]){
//																System.out.println(".");
																totalOccurances++;
															}
															
														}
//														System.out.println("testD:" + totalOccurances);
														if(totalOccurances == 1){
															currentSquare.setValue(i +1);
														}
														
														
													}
														//in col
//														System.out.println("testA:"+row + col);
														if(possibleValues[i]){
															int totalOccurances;
//															System.out.println("testB"+i);
															//check if only in row
															totalOccurances = 0;
															for(int scanRow = 0; scanRow < 9; scanRow++){
//																System.out.println("testC");
																if(board.getSquare(scanRow, col).getPossibleValues()[i]){
//																	System.out.println(".");
																	totalOccurances++;
																}
																
															
																
															}
//															System.out.println("testD:" + totalOccurances);
															if(totalOccurances == 1){
																currentSquare.setValue(i +1);
															}
														
																	}
														
														//in box
//														System.out.println("testA:"+row + col);
														if(possibleValues[i]){
															int totalOccurances;
//															System.out.println("testB"+i);
															//check if only in row
															totalOccurances = 0;
															Square[][] box = getBox(board, row, col);
															for(int scanRow = 0; scanRow < 3; scanRow++){
																for(int scanCol = 0; scanCol < 3; scanCol++){
//																System.out.println("testC");
																if(box[scanRow][scanCol].getPossibleValues()[i]){
//																	System.out.println(".");
																	totalOccurances++;
																}
																
															
																
															}
															}
//															System.out.println("testD:" + totalOccurances);
															if(totalOccurances == 1){
																currentSquare.setValue(i +1);
															}
														
																	}
																	

															}

													}
											}
									}

							}
					}

			}
		
		public static Square[][] getBox(Board board, int row, int col){
			
			int boxRow = (int)(((double)row / 9.0) * 3)*3;
			int boxCol = (int)(((double)col / 9.0) * 3)*3;

			Square[][] box = new Square[3][3];
			
			for(int i = 0; i < 3;i++){
				for(int j = 0; j < 3; j++){
					
//					System.out.println("Box includes ("+(boxRow+i)+", "+(boxCol+j)+")");
					box[i][j] = board.getSquare(boxRow+i, boxCol+j);
					
				}
									
			}
			return box;
		}
		
		
	}
