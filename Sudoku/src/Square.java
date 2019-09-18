import java.util.ArrayList;

public class Square
	{

		public int value;
		public boolean[] possibleValues = new boolean[9];

		public Square(int Value)
			{
				value = Value;
				if (value == -1)
					{
						for (int i = 0; i < 9; i++)
							{
								possibleValues[i] = true;
							}
					}else{
						for (int i = 0; i < 9; i++)
							{
								possibleValues[i] = false;
							}
					}
			}

		public int getValue()
			{
				return value;
			}

		public void setValue(int value)
			{
				this.value = value;
				this.clearPossibleValues();
			}

		public boolean[] getPossibleValues()
			{
				return possibleValues;
			}

		public void setPossibleValues(boolean[] possibleValues)
			{
				this.possibleValues = possibleValues;
			}

		public void setPossibleValue(boolean valuePolarity, int index)
			{
				this.possibleValues[index] = valuePolarity;
			}

		public boolean isIntPossible(int n)
			{
				return (possibleValues[n]);

			}
		
		public void clearPossibleValues()
			{
				boolean[] possibleValues2 = this.possibleValues;
				for (int i = 0; i < possibleValues2.length; i++)
					{
						possibleValues2[i] = false;
					}

			}
		
		public static void info(int row, int col){
			Square square = SudokuSolver.solvedBoard.getSquare(row, col);
			System.out.println("Info on ("+row+", "+col+"):\n"
					+ "Current Value:");
			System.out.println(square.getValue());
			System.out.println("Possible values:");
			for(int i = 0; i < 9; i++){
				if(square.getPossibleValues()[i]){
					System.out.println(i+1);
				}
			}
			
			
			
			
		}
		
		
		
	}
