import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonParserTest {
	public static void main(String[] args) {
		FileReader file = null;
		try {
			file = new FileReader("jsonFile.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
