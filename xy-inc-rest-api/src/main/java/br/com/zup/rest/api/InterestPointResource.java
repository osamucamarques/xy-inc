package br.com.zup.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.model.InterestPoint;
import br.com.zup.service.InterestPointService;

@RestController
public class InterestPointResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private InterestPointService service;

	@Autowired
	public InterestPointResource(InterestPointService service) {
		this.service = service;
	}

	@RequestMapping(value = "/xy-inc/list", method = RequestMethod.GET)
	public Iterable<InterestPoint> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/xy-inc/create", method = RequestMethod.POST)
	public InterestPoint create(@RequestBody InterestPoint ip) {
		return service.create(ip);
	}
}
