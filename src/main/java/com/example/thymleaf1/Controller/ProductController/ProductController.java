package com.example.thymleaf1.Controller.ProductController;

import com.example.thymleaf1.Category.Category;
import com.example.thymleaf1.Product.Product;
import com.example.thymleaf1.Repo.CategoryRepository;
import com.example.thymleaf1.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/products")
    public String listProducts(Model model){
        List<Product> listProducts=productRepository.findAll();
        model.addAttribute("listProducts",listProducts);
        return "products";
    }
    @GetMapping("/products/new")
    public String showProductForm(Model model){
        List<Category>listCategory=categoryRepository.findAll();
        model.addAttribute("product",new Product());
        model.addAttribute("listCategories",listCategory);
        return"product_form";
    }
    @RequestMapping(value = "product/save", method= RequestMethod.POST)
    public String saveProduct(@ModelAttribute("productsg") Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

}
