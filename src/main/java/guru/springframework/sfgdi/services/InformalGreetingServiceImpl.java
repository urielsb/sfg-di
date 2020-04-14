package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class InformalGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreetings() {
		return "Que onda loko!";
	}

}
