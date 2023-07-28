package by.softclub.menu_project.entity.dto;

import by.softclub.menu_project.entity.Dish;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MenuCategoryDto {
    
    private String name;

}
