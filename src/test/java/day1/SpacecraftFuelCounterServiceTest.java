package day1;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.mockito.Mockito;

public class SpacecraftFuelCounterServiceTest {
	
	@Test
	public void testCalculateFuelRequiredForSpaceCraft()
	{
		Spacecraft spacecraftMock = Mockito.mock(Spacecraft.class);
		SpacecraftModule module = new SpacecraftModule(1969);
		SpacecraftModule module2 = new SpacecraftModule(100756);
		List<SpacecraftModule> modules = new ArrayList<SpacecraftModule>();
		modules.add(module);
		modules.add(module2);
		Mockito.when(spacecraftMock.getSpacecraftModules()).thenReturn(modules);
		assertThat("Value of 0 should return 0", SpacecraftFuelCounterService.calculateFuelRequiredForSpaceCraft(spacecraftMock), equalTo(51312));
	}
}
