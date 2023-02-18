package com.example.knives.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
public class Knife {

    @JsonProperty
    @Getter
    private final UUID id;

    @JsonProperty
    @Getter
    private final String name;

    @JsonProperty
    @Getter
    private final int length;

    @JsonProperty
    @Getter
    private final KnifeType type;

    @JsonProperty
    @Getter
    private final BladeMaterial bladeMaterial;

    @JsonProperty
    @Getter
    private final HandleMaterial handleMaterial;

    @SuppressWarnings("unused")
    public enum KnifeType {
        FLIP,
        CARVING,
        CHEF,
        COMMANDO,
        STILETTO
    }

    @SuppressWarnings("unused")
    public enum BladeMaterial {
        STEEL,
        TITANIUM
    }

    @SuppressWarnings("unused")
    public enum HandleMaterial {
        COMPOSITE,
        WOOD,
        METAL
    }

}
