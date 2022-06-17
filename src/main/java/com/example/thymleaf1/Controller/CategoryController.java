package com.example.thymleaf1.Controller;

import com.example.thymleaf1.Category.Category;
import com.example.thymleaf1.Repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repo;
    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Category> listCategories=repo.findAll();
        model.addAttribute("listCategories",listCategories);
        return "categories";
    }
    @GetMapping("/categories/new")
    public String showCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return"Category_form";
    }
    @RequestMapping(value = "/categories/save", method= RequestMethod.POST)
    public String saveCategories(@ModelAttribute("category") Category category){
        repo.save(category);
        return "redirect:/categories";
    }
}
