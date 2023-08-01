package by.softclub.menu_project.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderDto {

    private LocalDateTime date;

    private Double cost;

    private int status;
}
