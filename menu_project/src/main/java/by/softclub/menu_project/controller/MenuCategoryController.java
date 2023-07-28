package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.MenuCategory;
import by.softclub.menu_project.entity.dto.MenuCategoryDto;
import by.softclub.menu_project.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu_categories")
@RequiredArgsConstructor
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @PostMapping("/add")
    public ResponseEntity<Void> addMenuCategory(@RequestBody MenuCategoryDto menuCategoryDto){
        menuCategoryService.addMenuCategory(menuCategoryDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/all")
    public List<MenuCategory> getMenuCategoories(){
        return menuCategoryService.getMenuCategories();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MenuCategory> getMenuCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(menuCategoryService.getMenuCategory(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MenuCategory> updateMenuCategory(@RequestBody MenuCategoryDto menuCategoryDto, @PathVariable("id") Long id){
        return ResponseEntity.ok(menuCategoryService.updateMenuCategory(menuCategoryDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMenuCategory(@PathVariable("id") Long id){
        menuCategoryService.deleteMenuCategory(id);
        return ResponseEntity.ok().build();
    }
}
