package by.softclub.menu_project.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {

    @JsonProperty("rest_id")
    Long restId;
    
    @JsonProperty("name")
    String name;

    @JsonProperty("cost")
    Integer cost;
}
