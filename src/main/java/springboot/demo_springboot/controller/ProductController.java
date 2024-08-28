package springboot.demo_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.demo_springboot.entity.ProductEntity;
import springboot.demo_springboot.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String getProducts(Model model) {
        List<ProductEntity> products = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/edit-to-cart/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "editProduct";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute("product") ProductEntity product) {
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete-to-cart/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/add-product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "addProduct";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") ProductEntity product) {
        productRepository.save(product);
        return "redirect:/";
    }
}