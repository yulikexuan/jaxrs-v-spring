// com.yuli.cloud.domain.repositories.IStormtrooperRepository.java

package com.yuli.cloud.domain.repositories;


import com.yuli.cloud.domain.model.Stormtrooper;

import java.util.Collection;


public interface IStormtrooperRepository {

    Collection<Stormtrooper> listStormtroopers();

    Stormtrooper getStormtrooper(String id);

    Stormtrooper addStormtrooper(Stormtrooper stormtrooper);

    Stormtrooper updateStormtrooper(String id, Stormtrooper stormtrooper);

    boolean deleteStormtrooper(String id);

}
