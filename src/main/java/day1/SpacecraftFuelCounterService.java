package day1;

import java.util.List;
import java.util.stream.Stream;

public class SpacecraftFuelCounterService 
{
	public static int calculateFuelRequiredForSpaceCraft(Spacecraft spacecraft)
	{
		List<SpacecraftModule> spacecraftModules = spacecraft.getSpacecraftModules();
		Stream<SpacecraftModule> stream = spacecraftModules.stream();
		return stream.map(x -> x.getMass())
		      .map(x -> x / 3)
		      .map(x -> x - 2)
		      .mapToInt(x -> x)
			  .sum();
	}
}
