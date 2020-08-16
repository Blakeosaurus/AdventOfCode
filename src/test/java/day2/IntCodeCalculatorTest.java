package day2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Test;

public class IntCodeCalculatorTest {
	@Test
    public void testInitialiseMemoryDefault() 
	{
        IntCodeCalculator calc = IntCodeCalculator.factoryIntCodeCalculatorForDefaultMemory();
        int noun = calc.getNoun();
        int verb = calc.getVerb();
        assertThat(noun, equalTo(0));
        assertThat(verb, equalTo(0));
    }
	
	@Test
	public void testInitialiseSetNoun()
	{
		IntCodeCalculator calc = new IntCodeCalculator("0,0,0,0");
		calc.setNoun(7);
		int noun = calc.getNoun();
		assertThat(noun, equalTo(7));
	}
	
	@Test
	public void testInitialiseSetVerb()
	{
		IntCodeCalculator calc = new IntCodeCalculator("0,0,0,0");
		calc.setVerb(9);
		int noun = calc.getVerb();
		assertThat(noun, equalTo(9));
	}
	
	@Test
	public void testMemorySize()
	{
		IntCodeCalculator calc = new IntCodeCalculator("1,2,3,4,5");
		int memorySize = calc.getMemory().size();
		assertThat(memorySize, equalTo(5));
	}
	
	@Test
	public void testPerformAddOpp()
	{
		//1 is opp code for add.
		IntCodeCalculator calc = new IntCodeCalculator("1,1,2,2");
		
		calc.run();
		List<Integer> memory = calc.getMemory();
		int output = memory.get(2).intValue();
		assertThat(output, equalTo(3));
	}
	
	@Test
	public void testPerformAddMultiplyOpp()
	{
		//2 is opp code for add.
		IntCodeCalculator calc = new IntCodeCalculator("2,1,2,2");
		
		calc.run();
		List<Integer> memory = calc.getMemory();
		int output = memory.get(2).intValue();
		assertThat(output, equalTo(2));
	}
	
	@Test
	public void testPerformCalculatorRun()
	{
		IntCodeCalculator calc6 = new IntCodeCalculator("1,1,1,4,99,5,6,0,99");
		calc6.run();
		int result6 = calc6.getResult();
		assertThat(result6, equalTo(30));
	}
}
