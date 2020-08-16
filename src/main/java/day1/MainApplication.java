package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainApplication {
	
	public static final String INPUT_FILE_LOCATION = "src/main/resources/input.txt";
	
	public static void main(String[] args) 
	{
			//The super long winded objecty way.
			Spacecraft spacecraft = new Spacecraft();
			int requiredFuelUsingObjects = SpacecraftFuelCounterService.calculateFuelRequiredForSpaceCraft(spacecraft);
			System.out.println("Total fuel required using objects: " + requiredFuelUsingObjects);
			
			//Just using streams. Only for part 1
			try {
				Stream<String> stream = Files.lines(Paths.get(INPUT_FILE_LOCATION));
				int totalRequiredFuelJustStreams = stream.mapToInt(Integer::valueOf)
						.map(x -> x/3)
						.map(x -> x - 2)
						.sum();
				stream.close();
				System.out.println("Total fuel required, streams only: " + totalRequiredFuelJustStreams);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
