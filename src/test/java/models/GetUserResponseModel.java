package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GetUserResponseModel {

    DataList data;
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class DataList {
        int id;
        @JsonProperty("first_name")
        String firstName;

    }

}
