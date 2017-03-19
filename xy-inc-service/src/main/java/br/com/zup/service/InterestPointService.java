package br.com.zup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.model.InterestPoint;
import br.com.zup.repository.InterestPointRepository;

@Service
public class InterestPointService {

	@Autowired
	private InterestPointRepository repository;

	public void validate() {
		// ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// Validator validator = factory.getValidator();
	}

	public InterestPoint create(InterestPoint ip) {
		return repository.save(ip);
	}

	public InterestPoint create(String name, int x, int y) {
		InterestPoint ip = new InterestPoint(name, x, y);
		return repository.save(ip);
	}

	public Iterable<InterestPoint> findAll() {
		return repository.findAll();
	}
}
