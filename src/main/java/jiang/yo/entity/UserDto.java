package jiang.yo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String vin;

    private UserInfo user;

    @Data
    public static class UserInfo {

        @JsonProperty(value = "10_name")
        private String name;

        @JsonProperty(value = "20_age")
        private Integer age;
    }

}
