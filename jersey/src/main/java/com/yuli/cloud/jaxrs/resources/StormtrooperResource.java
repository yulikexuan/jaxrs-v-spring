//: com.yuli.cloud.jaxrs.resources.StormtrooperResource.java


package com.yuli.cloud.jaxrs.resources;


import com.yuli.cloud.domain.model.Stormtrooper;
import com.yuli.cloud.domain.repositories.IStormtrooperRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collection;


/**
 * Stormtrooper Resource for Jersey.
 */
@Path("/troopers")
@Produces("application/json")
public class StormtrooperResource {

	private final IStormtrooperRepository stormtrooperRepository;

	@Inject
	public StormtrooperResource(IStormtrooperRepository stormtrooperRepository) {
		this.stormtrooperRepository = stormtrooperRepository;
	}

	/**
	 * Returns a Collection of all Stormtroopers.
	 * @return Returns a Collection of all Stormtroopers.
	 */
	@GET
	public Collection<Stormtrooper> listTroopers() {
		return stormtrooperRepository.listStormtroopers();
	}

	@Path("/{id}")
	@GET
	public Stormtrooper getTrooper(@PathParam("id") String id)
			throws NotFoundException {

		Stormtrooper stormtrooper =
				this.stormtrooperRepository.getStormtrooper(id);

		if (stormtrooper == null) {
			throw new NotFoundException();
		}

		return stormtrooper;
	}

	@POST
	public Stormtrooper createTrooper(Stormtrooper trooper) {
		return this.stormtrooperRepository.addStormtrooper(trooper);
	}

	@Path("/{id}")
	@POST
	public Stormtrooper updateTrooper(
			@PathParam("id") String id, Stormtrooper updatedTrooper)
			throws NotFoundException {
		return this.stormtrooperRepository.updateStormtrooper(id, updatedTrooper);
	}

	@Path("/{id}")
	@DELETE
	public void deleteTrooper(@PathParam("id") String id) {
		this.stormtrooperRepository.deleteStormtrooper(id);
	}

}///:~