package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Session {
    @JsonProperty("date")
    private String date;
    @JsonProperty("vaccine")
    private String vaccine;
    @JsonProperty("slots")
    private List<String> slots = null;
    @JsonProperty("min_age_limit")
    private Integer minAgeLimit;
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("available_capacity")
    private Integer availableCapacity;
    @JsonProperty("available_capacity_dose2")
    private Integer availableCapacityDose2;
    @JsonProperty("available_capacity_dose1")
    private Integer availableCapacityDose1;
}
