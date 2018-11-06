package com.gabchak.controller;

import com.gabchak.model.Category;
import com.gabchak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public ModelAndView showAllCategories(ModelAndView vm) {

        vm.setViewName("categories");
        vm.addObject("categories", categoryService.findAll());

        return vm;
    }

    @RequestMapping(path = "/category_{id}", method = RequestMethod.GET)
    public ModelAndView findCategoryById(@PathVariable Long id, ModelAndView vm) {

        vm.setViewName("category");
        vm.addObject("category", categoryService.findByIdWithProductList(id));

        return vm;
    }

    @RequestMapping(path = "/{categoryName}", method = RequestMethod.GET)
    public ModelAndView findCategoryByName(@PathVariable String categoryName, ModelAndView vm) {
        Category category = categoryService.findByName(categoryName);
        vm.setViewName("category");
        vm.addObject("category", categoryService.findByIdWithProductList(category.getId()));

        return vm;
    }

    @GetMapping("/admin/categories")
    public ModelAndView categoryAdminList(ModelAndView vm) {
        vm.setViewName("categoryAdminList");
        vm.addObject("categories", categoryService.findAll());
        return vm;
    }

    @GetMapping("/admin/categories/create_category")
    public ModelAndView createCategoryPage(ModelAndView vm) {
        vm.setViewName("category");
        vm.addObject("category", new Category());
        return vm;
    }

    @PostMapping("/admin/categories/create_category")
    public ModelAndView createCategory(@PathVariable String categoryName, ModelAndView vm) {
        categoryService.addCategory(new Category(categoryName));
        vm.addObject("categories", categoryService.findAll());
        return vm;
    }

    @PostMapping("/admin/categories/{id}_delete")
    public ModelAndView deleteCategory(@PathVariable Long id, ModelAndView vm) {
        categoryService.deleteById(id);
        vm.setViewName("categoryAdminList");
        vm.addObject("categories", categoryService.findAll());
        return vm;
    }
    //TODO: page edit category
}
