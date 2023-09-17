package com.example.grocerystore.controller;

import com.example.grocerystore.dto.ProductRequest;
import com.example.grocerystore.dto.ProductResponse;
import com.example.grocerystore.dto.UserRequest;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.Product;
import com.example.grocerystore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/search")
    public String searchProducts(@RequestParam(value = "query",required = false) String query, Model model) {
        List<ProductResponse> products = productService.searchProducts(query);
        model.addAttribute("products", products);
        return "/product/search";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") ProductRequest productRequest) {
        //Страница для добавления компании в БД
        return "/product/create";
    }

    @PostMapping("/create")
    public String create(ProductRequest productRequest, Model model) throws FileNotFoundException {
        model.addAttribute("product", productService.create(productRequest));
        return "redirect:/product/search";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, ProductRequest productRequest, Model model) {
        model.addAttribute("product", productService.update(id, productRequest));
        return "redirect:/product/search";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product/search";
    }


}

