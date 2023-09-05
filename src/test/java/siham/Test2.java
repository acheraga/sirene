package siham;

import java.io.IOException;
import java.util.Locale;

import org.junit.jupiter.api.Test;

public class Test2 {
	@Test
	public void main() throws IOException {
		String[] countryCodes = Locale.getISOCountries();
		for (String string : countryCodes) {
			System.out.println(string);
		}
		
	}

}
