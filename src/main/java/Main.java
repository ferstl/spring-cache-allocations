import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			doInContext(ctx);
		}
	}

	private static void doInContext(ConfigurableApplicationContext ctx) {
		waitForUserInput("Connect Profiler");

		MyService service = ctx.getBean(MyService.class);
		for (int i = 0; i < 1_000_000; i++) {
			service.doSomething("test");
		}

		waitForUserInput("Disconnect Profiler");
	}

	private static void waitForUserInput(String msg) {
		System.out.println(msg + " and press Enter...");
		try {
			// Don't close System.in
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		  reader.readLine();
	  } catch (IOException e) {
	  	throw new UncheckedIOException(e);
		}
	}
}
