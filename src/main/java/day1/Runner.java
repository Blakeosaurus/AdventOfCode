package day1;


public class Runner {
	public static void main(String[] args) {
			Spacecraft spacecraft = new Spacecraft();
			int requiredFuel = SpacecraftFuelCounterService.calculateFuelRequiredForSpaceCraft(spacecraft);
			System.out.println("Total fuel required: " + requiredFuel);
	  }
}
