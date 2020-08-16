package day1;

public class SpacecraftModuleFuelCounterService {
	public static int calculateFuelRequiredForSpacecraftModule(SpacecraftModule spacecraftModule)
	{
		return calculateTotalFuelRequiredForMass(spacecraftModule.getMass());
	}
	
	/**
	 * A mass requires fuel given by the sum of the required fuel and iteratively the fuel required for the fuel.
	 */
	public static int calculateTotalFuelRequiredForMass(int mass)
	{
		int totalRequired = 0;
		
		int fuelRequired = calculateFuelRequiredForMassOrFuel(mass);
		while (fuelRequired > 0)
		{
			totalRequired += fuelRequired;
			fuelRequired = calculateFuelRequiredForMassOrFuel(fuelRequired);
		}
		
		return totalRequired;
	}
	
	/**
	 * Mass requires fuel. Given by the floor(mass/3) - 2.
	 * Fuel also requires fuel, given by the same equation. Unless the required fuel is <= 0, then it requires 0 fuel.
	 */
	public static int calculateFuelRequiredForMassOrFuel(int massOrFuel)
	{
		int required = (massOrFuel / 3) - 2;
		if (required <= 0)
		{
			return 0;
		}
		else
		{
			return required;
		}
	}
}
