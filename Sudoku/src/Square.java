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
		
		public void clearPossibleValues(){
			for(boolean b: this.possibleValues){
				b = false;
			}
			 
			
			
		}
	}
