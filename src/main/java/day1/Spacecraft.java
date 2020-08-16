package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Spacecraft 
{
	private List<SpacecraftModule> spacecraftModules = initialiseSpacecraftModules();

	private List<SpacecraftModule> initialiseSpacecraftModules() 
	{
		List<SpacecraftModule> ret = new ArrayList<SpacecraftModule>();
		try
		{
			Stream<String> stream = Files.lines(Paths.get(MainApplication.INPUT_FILE_LOCATION));
			ret = stream.map(Integer::valueOf)
						.map(x -> new SpacecraftModule(x))
					    .collect(Collectors.toList());
			stream.close();
					
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}

	public List<SpacecraftModule> getSpacecraftModules() {
		return spacecraftModules;
	}
}
