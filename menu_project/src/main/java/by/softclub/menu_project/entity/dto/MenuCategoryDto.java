package by.softclub.menu_project.entity.dto;

import by.softclub.menu_project.entity.Dish;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MenuCategoryDto {

    @NotBlank
    private String name;

    private List<Long> dishes;

}
