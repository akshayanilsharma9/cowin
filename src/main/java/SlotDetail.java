import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;

@Getter
@Setter
@NoArgsConstructor
public class SlotDetail {

    /*
    {"pincode":826001,"sessions":[{"date":"21-05-2021","vaccine":"COVISHIELD",
    "slots":["09:00AM-11:00AM","11:00AM-01:00PM","01:00PM-03:00PM","03:00PM-06:00PM"],
    "min_age_limit":45,"session_id":"a729e6b5-1d18-4565-9b02-02e39a7091cb",
    "available_capacity":1,"available_capacity_dose2":0,"available_capacity_dose1":1},
    {"date":"22-05-2021","vaccine":"COVISHIELD","slots":["09:00AM-11:00AM","11:00AM-01:00PM","01:00PM-03:00PM","03:00PM-06:00PM"],
    "min_age_limit":45,"session_id":"88ca3f5b-b17a-4ff9-b67b-1818701ea3c4","available_capacity":1,"available_capacity_dose2":1,
    "available_capacity_dose1":0},{"date":"23-05-2021","vaccine":"COVISHIELD",
    "slots":["09:00AM-11:00AM","11:00AM-01:00PM","01:00PM-03:00PM","03:00PM-06:00PM"],"min_age_limit":45,
    "session_id":"b7dd254e-1f89-4c37-b4a4-51f104e0f5e2","available_capacity":0,"available_capacity_dose2":0,
    "available_capacity_dose1":0},{"date":"24-05-2021","vaccine":"COVISHIELD",
    "slots":["09:00AM-11:00AM","11:00AM-01:00PM","01:00PM-03:00PM","03:00PM-06:00PM"],"min_age_limit":45,
    "session_id":"b67012f6-c822-4a44-a531-e393dc1ff1db","available_capacity":0,"available_capacity_dose2":0,"available_capacity_dose1":0},
    {"date":"25-05-2021","vaccine":"COVISHIELD","slots":["09:00AM-11:00AM","11:00AM-01:00PM","01:00PM-03:00PM","03:00PM-06:00PM"],
    "min_age_limit":45,"session_id":"1b6077c4-4ad7-4c6d-8fc7-451e7f56729f","available_capacity":0,"available_capacity_dose2":0,
    "available_capacity_dose1":0}],"address":"Bartar","fee_type":"Paid","long":0,"district_name":"Dhanbad","block_name":"Dhanbad Sadar",
    "center_id":646564,"state_name":"Jharkhand","name":"Tan Man Hospital","from":"09:00:00","to":"18:00:00","lat":0}
     */
    @JsonProperty("pincode")
    private Integer pincode;
    @JsonProperty("sessions")
    private List<Session> sessions = null;
    @JsonProperty("address")
    private String address;
    @JsonProperty("fee_type")
    private String feeType;
    @JsonProperty("long")
    private Integer _long;
    @JsonProperty("district_name")
    private String districtName;
    @JsonProperty("block_name")
    private String blockName;
    @JsonProperty("center_id")
    private Integer centerId;
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("lat")
    private Integer lat;
}