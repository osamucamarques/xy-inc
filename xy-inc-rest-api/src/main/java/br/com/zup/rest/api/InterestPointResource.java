package br.com.zup.rest.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.exception.ServiceException;
import br.com.zup.model.InterestPoint;
import br.com.zup.service.InterestPointService;
import br.com.zup.vo.InterestPointVO;

@RestController
public class InterestPointResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private InterestPointService service;

	@Autowired
	public InterestPointResource(InterestPointService service) {
		this.service = service;
	}

	@RequestMapping(value = "/xy-inc/api/interestpoint/list", method = RequestMethod.GET)
	public ResponseEntity<List<InterestPoint>> findAll() {
		logger.info("/xy-inc/list has requested");
		List<InterestPoint> points = service.findAll();
		return new ResponseEntity<List<InterestPoint>>(points, HttpStatus.OK);
	}

	@RequestMapping(value = "/xy-inc/api/interestpoint/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InterestPoint> findById(@PathVariable("id") long id) {
		logger.info("/xy-inc/api/interestpoint/{id} has requested");
		InterestPoint ip = service.findById(id);
		if (ip == null) {
			logger.info("InterestPoint with id " + id + " not found");
		}
		return new ResponseEntity<InterestPoint>(ip, HttpStatus.OK);
	}

	@RequestMapping(value = "/xy-inc/api/interestpoint/nearby/{x}/{y}/{dmax}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InterestPoint>> findNearBy(@PathVariable("x") int x, @PathVariable("y") int y,
			@PathVariable("dmax") int dmax) {
		logger.info("/xy-inc/api/interestpoint/nearby/{x}/{y}/{dmax} has requested");
		List<InterestPoint> list = service.findNearBy(x, y, dmax);
		if (CollectionUtils.isEmpty(list)) {
			logger.info("No InterestPoint near by was found");
		}
		return new ResponseEntity<List<InterestPoint>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/xy-inc/api/interestpoint/create", method = RequestMethod.POST)
	public ResponseEntity<InterestPoint> create(@RequestBody InterestPointVO valueObject) {
		logger.info("/xy-inc/api/interestpoint/create has requested");
		logger.info("parameters: " + valueObject.toString());

		InterestPoint ip = service.save(valueObject);
		return new ResponseEntity<InterestPoint>(ip, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/xy-inc/api/interestpoint/change/{id}", method = RequestMethod.PUT)
	public ResponseEntity<InterestPoint> change(@PathVariable("id") long id, @RequestBody InterestPointVO valueObject)
			throws ServiceException {
		logger.info("/xy-inc/api/interestpoint/change/{id} has requested");
		logger.info("parameters: " + valueObject.toString());

		InterestPoint ip = service.update(id, valueObject);
		return new ResponseEntity<InterestPoint>(ip, HttpStatus.OK);
	}

	@RequestMapping(value = "/xy-inc/api/interestpoint/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InterestPoint> remove(@PathVariable("id") long id) {
		logger.info("/xy-inc/api/interestpoint/remove has requested");
		service.delete(id);
		return new ResponseEntity<InterestPoint>(HttpStatus.NO_CONTENT);
	}
}
