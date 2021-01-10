package com.example.artistapi.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Artist {
    private final UUID id;
    private final String name;
    private final Collection<String> songs;

    public Artist(@JsonProperty("id") UUID id,
                  @JsonProperty("name")String name) {
        this.id = id;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public Collection<String> getSongs() {
        return songs;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}