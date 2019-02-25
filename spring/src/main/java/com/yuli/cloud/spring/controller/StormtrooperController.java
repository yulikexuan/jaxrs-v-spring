//: com.yuli.cloud.spring.controller.StormtrooperController.java


package com.yuli.cloud.spring.controller;


import com.yuli.cloud.domain.model.Stormtrooper;
import com.yuli.cloud.domain.repositories.IStormtrooperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/jaxrs-v-spring/spring/troopers")
public class StormtrooperController {

	private IStormtrooperRepository stormtrooperRepository;

	@Autowired
	public StormtrooperController(
			IStormtrooperRepository stormtrooperRepository) {

		this.stormtrooperRepository = stormtrooperRepository;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Collection<Stormtrooper> listTroopers() {
		return this.stormtrooperRepository.listStormtroopers();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Stormtrooper getTrooper(@PathVariable("id") String id) {
		Stormtrooper stormtrooper =
				this.stormtrooperRepository.getStormtrooper(id);
		return stormtrooper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Stormtrooper createTrooper(@RequestBody Stormtrooper trooper) {
		return this.stormtrooperRepository.addStormtrooper(trooper);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Stormtrooper updateTrooper(@PathVariable("id") String id,
	                                  @RequestBody Stormtrooper updatedTrooper) {

		return this.stormtrooperRepository.updateStormtrooper(id, updatedTrooper);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteTrooper(@PathVariable("id") String id) {
		this.stormtrooperRepository.deleteStormtrooper(id);
	}

}///:~