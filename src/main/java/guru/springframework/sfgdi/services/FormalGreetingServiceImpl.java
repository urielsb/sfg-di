package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class FormalGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreetings() {
		return "Good Morning!";
	}

}
