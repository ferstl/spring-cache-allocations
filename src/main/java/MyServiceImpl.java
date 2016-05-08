

public class MyServiceImpl implements MyService {

	@Override
	public String doSomething(String param) {
		System.out.println("real service call");
		return param.toUpperCase();
	}

}
