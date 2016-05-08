import org.springframework.cache.annotation.Cacheable;

public interface MyService {

	@Cacheable(cacheNames = "default")
	String doSomething(String param);
}
