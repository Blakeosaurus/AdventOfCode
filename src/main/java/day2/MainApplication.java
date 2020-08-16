package day2;

public class MainApplication {
	public static void main(String[] args) 
	{
		//Part 1
		IntCodeCalculator calcPart1 = IntCodeCalculator.factoryIntCodeCalculatorForDefaultMemory();
		calcPart1.setNoun(12);
		calcPart1.setVerb(2);
		calcPart1.run();
		System.out.println("Solution to part 1 is " + calcPart1.getResult());
		
		//Part 2
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				IntCodeCalculator calc = IntCodeCalculator.factoryIntCodeCalculatorForDefaultMemory();
				calc.setNoun(i);
				calc.setVerb(j);
				calc.run();
				if (calc.hasFinishedSuccessfully()
				  && calc.getResult() == 19690720)
				{
					System.out.println("Solution to part 2 is " + (100 * i) + j);
					break;
				}
			}
		}
	}
}
