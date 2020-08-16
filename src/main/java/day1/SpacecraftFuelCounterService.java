package day1;

import java.util.List;
import java.util.stream.Stream;

public class SpacecraftFuelCounterService 
{
	/**
	 * Fuel required to launch a given module is based on its mass. 
	 * Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
	 */
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
