package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.Dish;
import by.softclub.menu_project.entity.MenuCategory;
import by.softclub.menu_project.entity.dto.MenuCategoryDto;
import by.softclub.menu_project.repository.DishRepository;
import by.softclub.menu_project.repository.MenuCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final DishRepository dishRepository;

    public void addMenuCategory(MenuCategoryDto menuCategoryDto){
        MenuCategory menuCategory = new MenuCategory();
        BeanUtils.copyProperties(menuCategoryDto, menuCategory);
        List<Dish> dishes = dishRepository.findAllByIds(menuCategoryDto.getDishes());
        menuCategory.setDishes(dishes);
        menuCategoryRepository.save(menuCategory);
    }

    public List<MenuCategory> getMenuCategories(){
        return menuCategoryRepository.findAll();
    }

    public MenuCategory getMenuCategory(Long id){
        return menuCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu category not found"));
    }

    public MenuCategory updateMenuCategory(MenuCategoryDto menuCategoryDto, Long id){
        MenuCategory menuCategory = menuCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu category not found"));
        BeanUtils.copyProperties(menuCategoryDto, menuCategory, "dishes");
        menuCategoryRepository.save(menuCategory);
        return menuCategory;
    }

    public void deleteMenuCategory(Long id){
        menuCategoryRepository.deleteById(id);
    }

}
