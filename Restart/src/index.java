import java.io.File;
import java.io.IOException;

public class index {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		File file=new File("prog.jar");
		try {
			Runtime.getRuntime().exec("java -jar prog.jar");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}