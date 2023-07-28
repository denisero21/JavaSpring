package by.softclub.menu_project.entity.dto;

import by.softclub.menu_project.entity.MenuCategory;
import by.softclub.menu_project.entity.Order;
import by.softclub.menu_project.entity.Restaurant;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishDto {

    private Long restaurant;

    private String name;

    private Double cost;

    private Long menuCategory;
}
