package com.yuli.cloud.domain.repositories;


import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.IntStream;

import com.yuli.cloud.domain.model.Stormtrooper;


public class DefaultStormtrooperRepository implements IStormtrooperRepository {

    final static private String[] trooperTypes = {
            "Basic", "Space", "Aquatic", "Marine", "Jump", "Sand"
    };

    final static private String[] planetsList = {
            "Coruscant", "Tatooine", "Felucia", "Hoth", "Naboo", "Serenno"
    };

    final static private String[] speciesList = {
            "Human", "Kel Dor", "Nikto", "Twi'lek", "Unidentified"
    };

    static final private Random RANDOM = new SecureRandom();

    final private Map<String, Stormtrooper> trooperMap =
                Collections.synchronizedSortedMap(new TreeMap<String, Stormtrooper>());

    public DefaultStormtrooperRepository() {
        IntStream.range(0, 50).forEach(i -> addStormtrooper(randomTrooper()));
    }

    public Collection<Stormtrooper> listStormtroopers() {
        return Collections.unmodifiableCollection(this.trooperMap.values());
    }

    public Stormtrooper getStormtrooper(String id) {
        return this.trooperMap.get(id);
    }

    public Stormtrooper addStormtrooper(Stormtrooper stormtrooper) {

        if (stormtrooper.getId() == null ||
                stormtrooper.getId().trim().isEmpty()) {
            stormtrooper = Stormtrooper.create(generateRandomId(),
                    stormtrooper.getPlanetOfOrigin(),
                    stormtrooper.getSpecies(),
                    stormtrooper.getType());
        }

        this.trooperMap.put(stormtrooper.getId(), stormtrooper);

        return stormtrooper;
    }

    public Stormtrooper updateStormtrooper(String id, Stormtrooper stormtrooper) {
        // we are just backing with a map, so just call add.
        // NOTE: this does NOT cover all use-cases, null objects, id change, etc.
        return addStormtrooper(stormtrooper);
    }

    public boolean deleteStormtrooper(String id) {
        return this.trooperMap.remove(id) != null;
    }

    private static String generateRandomId() {
        // HIGH chance of collisions, but, this is all for fun...
        return "FN-" + String.format("%04d", RANDOM.nextInt(9999));
    }

    private static Stormtrooper randomTrooper(String id) {

        String planet = planetsList[RANDOM.nextInt(planetsList.length)];
        String species = speciesList[RANDOM.nextInt(speciesList.length)];
        String type = trooperTypes[RANDOM.nextInt(trooperTypes.length)];

        return Stormtrooper.create(id, planet, species, type);
    }

    private static Stormtrooper randomTrooper() {
        return randomTrooper(generateRandomId());
    }
}
