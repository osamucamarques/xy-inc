package br.com.zup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.exception.ServiceException;
import br.com.zup.model.InterestPoint;
import br.com.zup.repository.InterestPointRepository;
import br.com.zup.vo.InterestPointVO;

@Service
public class InterestPointService {

	private InterestPointRepository repository;

	@Autowired
	public InterestPointService(InterestPointRepository repository) {
		this.repository = repository;
	}

	public InterestPoint save(InterestPointVO valueObject) {
		if (valueObject == null) {
			throw new IllegalArgumentException("valueObject don't be null");
		}

		InterestPoint ip = new InterestPoint(valueObject.getName(), valueObject.getX(), valueObject.getY());
		return repository.save(ip);
	}

	public InterestPoint update(long id, InterestPointVO valueObject) throws ServiceException {
		if (valueObject == null) {
			throw new IllegalArgumentException("valueObject don't be null");
		}

		InterestPoint current = findById(id);

		if (current == null) {
			throw new ServiceException("Interest point not found");
		}

		current.setName(valueObject.getName());
		current.setX(valueObject.getX());
		current.setY(valueObject.getY());

		return repository.save(current);
	}

	public void delete(long id) {
		repository.delete(id);
	}

	public List<InterestPoint> findAll() {
		return (List<InterestPoint>) repository.findAll();
	}

	public InterestPoint findById(long id) {
		return repository.findOne(id);
	}

	public List<InterestPoint> findNearBy(int x, int y, int dmax) {
		return (List<InterestPoint>) repository.findNearBy(x, y, dmax);
	}
}
