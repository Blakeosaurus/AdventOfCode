package day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntCodeCalculator 
{
	private List<Integer> memory = null;
	private int runStatus = RUN_STATUS_NOT_STARTED;
	
	private static final String DEFAULT_MEMORY_STR = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,2,0,14,0";
	
	private static final int NOUN_INDEX = 1;
	private static final int VERB_INDEX = 2;
	
	private static final int OPP_CODE_ADD 		= 1;
	private static final int OPP_CODE_MULTIPLY  = 2;
	private static final int OPP_CODE_STOP 		= 99;
	
	private static final int RUN_STATUS_NOT_STARTED = -1;
	private static final int RUN_STATUS_FATAL_ERROR = 0;
	private static final int RUN_STATUS_FINISHED 	= 1;
	
	/**
	 * Default factory for the memory supplied by advent of code.
	 */
	public static IntCodeCalculator factoryIntCodeCalculatorForDefaultMemory()
	{
		return new IntCodeCalculator(DEFAULT_MEMORY_STR);
	}
	
	
	public IntCodeCalculator(String memoryStr)
	{
		List<String> strList = Arrays.asList(memoryStr.split(","));
		this.memory = strList.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

	public void run() 
	{
		for (int i = 0; i < memory.size() - 1; i += 4)
		{
			int oppCode = memory.get(i).intValue();
			int inputAIndex = memory.get(i + 1);
			int inputA = memory.get(inputAIndex);
			int inputBIndex = memory.get(i + 2);
			int inputB = memory.get(inputBIndex);
			int outputIndex = memory.get(i + 3);
			if (oppCode == OPP_CODE_ADD)
			{
				performAddOpp(inputA, inputB, outputIndex);
			}
			else if (oppCode == OPP_CODE_MULTIPLY)
			{
				performMultiplyOpp(inputA, inputB, outputIndex);
			}
			else if (oppCode == OPP_CODE_STOP)
			{
				runStatus = RUN_STATUS_FINISHED;
				return;
			}
			else
			{
				System.out.println("Fatal error!!!");
				runStatus = RUN_STATUS_FATAL_ERROR;
				return;
			}
		}
		
		runStatus = RUN_STATUS_FINISHED;
	}

	private void performMultiplyOpp(int inputA, int inputB, int outputIndex) {
		int outputVal = inputA * inputB;
		memory.set(outputIndex, Integer.valueOf(outputVal));
	}

	private void performAddOpp(int inputA, int inputB, int outputIndex) {
		int outputVal = inputA + inputB;
		memory.set(outputIndex, Integer.valueOf(outputVal));
	}

	public boolean hasFinishedSuccessfully() {
		return runStatus == RUN_STATUS_FINISHED;
	}
	
	/**
	 * Gets/Sets
	 */
	public List<Integer> getMemory() 
	{
		return memory;
	}
	public void setMemory(List<Integer> memory) 
	{
		this.memory = memory;
	}

	public int getNoun() 
	{
		return memory.get(NOUN_INDEX);
	}
	public void setNoun(int noun)
	{
		memory.set(NOUN_INDEX, Integer.valueOf(noun));
	}
	public int getVerb() 
	{
		return memory.get(VERB_INDEX);
	}
	public void setVerb(int verb)
	{
		memory.set(VERB_INDEX, Integer.valueOf(verb));
	}
	public int getResult()
	{
		return memory.get(0);
	}
}
