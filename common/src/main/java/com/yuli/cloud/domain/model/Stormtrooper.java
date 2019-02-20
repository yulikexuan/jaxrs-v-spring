package com.yuli.cloud.domain.model;


public class Stormtrooper {

    private final String id;
    private final String planetOfOrigin;
    private final String species;
    private final String type;

    private Stormtrooper(String id, String planetOfOrigin, String species,
                        String type) {
        this.id = id;
        this.planetOfOrigin = planetOfOrigin;
        this.species = species;
        this.type = type;
    }

    public static Stormtrooper create(String id, String planetOfOrigin,
                                      String species, String type) {

        return new StormtrooperBuilder()
                .setId(id)
                .setPlanetOfOrigin(planetOfOrigin)
                .setSpecies(species)
                .setType(type)
                .createStormtrooper();
    }

    public String getId() {
        return id;
    }

    public String getPlanetOfOrigin() {
        return planetOfOrigin;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public static StormtrooperBuilder getBuilder() {
        return new StormtrooperBuilder();
    }

    static class StormtrooperBuilder {

        private String id;
        private String planetOfOrigin;
        private String species;
        private String type;

        private StormtrooperBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public StormtrooperBuilder setPlanetOfOrigin(String planetOfOrigin) {
            this.planetOfOrigin = planetOfOrigin;
            return this;
        }

        public StormtrooperBuilder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public StormtrooperBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public Stormtrooper createStormtrooper() {
            return new Stormtrooper(id, planetOfOrigin, species, type);
        }
    }

}
