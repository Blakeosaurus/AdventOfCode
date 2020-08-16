package day1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ModuleTest {
	@Test
    public void testCreateModule() {
        SpacecraftModule myModule = new SpacecraftModule(5);
        assertThat(myModule.getMass(), equalTo(5));
    }
}
