package apitest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PetPayload {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;
    @JsonProperty("status")
    private String status;

    public PetPayload(String name, int id, String status) {
        this.name = name;
        this.id = id;
        this.status = status;
    }

}
