package com.dydko.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {

    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;

    // uproszczone typy: lista elementów z polem "type" -> {name, url}
    private List<TypeWrapper> types;

    // stats: lista elementów z base_stat + zagnieżdżony obiekt "stat" -> {name, url}
    private List<StatWrapper> stats;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TypeWrapper {
        private Integer slot;
        private NamedResource type; // "type": { "name": "...", "url": "..." }
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StatWrapper {
        private Integer base_stat;
        private Integer effort;
        private NamedResource stat;  // "stat": { "name": "...", "url": "..." }
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NamedResource {
        private String name;
        private String url;
    }
}