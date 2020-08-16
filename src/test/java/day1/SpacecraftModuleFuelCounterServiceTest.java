package day1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class SpacecraftModuleFuelCounterServiceTest {
	@Test
    public void testCalculateFuelRequiredForMassOrFuel() 
	{
		//Anything that is calculated to 0 should return 0. an input of 6 should return 0.
		assertThat("Value of 0 should return 0", SpacecraftModuleFuelCounterService.calculateFuelRequiredForMassOrFuel(6), equalTo(0));
		
		//Anything that is calculated to < 0 should return 0. an input of 5 should return 0.
		assertThat("Value of < 0 should return 0", SpacecraftModuleFuelCounterService.calculateFuelRequiredForMassOrFuel(6), equalTo(0));
		
		//Anything that is calculated to > 0 should return the actual value. e.g. an input of 14 should return 2.
		assertThat("Value of > 0 should return itself", SpacecraftModuleFuelCounterService.calculateFuelRequiredForMassOrFuel(14), equalTo(2));
    }
}
