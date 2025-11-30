package com.dydko.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse1 {
    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
    private List<StatWrapper> stats;
    private List<TypeWrapper> types;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StatWrapper {
        private Integer base_stat;
        private Integer effort;
        private NamedResource stat;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TypeWrapper {
        private Integer slot;
        private NamedResource type;
    }


    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NamedResource {
        private String name;
        private String url;
    }
}
