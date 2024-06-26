package com.example.crud.Controllers;

import com.example.crud.entity.Product;
import com.example.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
//        System.out.println("product==========================================");
        this.productService = productService;
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "redirect:product/add";
    }
    @PostMapping("/add")
    public String saveProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/Product/list";
    }

    @GetMapping("/edit")
    public String editProduct(Model model, int id) {
        Optional<Product> product = productService.getProductById(id);
        model.addAttribute("product", product.get());
        return "redirect:/Product/list";
    }
    @PostMapping("/update")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/Product/list";
    }

    @GetMapping("/delete")
    public String deleteProduct(Product product) {
        productService.deleteProduct(product.p_id);
        return "redirect:/Product/list";
    }
}
