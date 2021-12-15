package com.example.springbootwk8task.Controller;

import com.example.springbootwk8task.DTO.ProductRepository;
import com.example.springbootwk8task.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/listProduct")
    public String showSampleView(Model model){

        Product p = new Product();
        Long id = (long) 1;
        p = productRepository.findById(id).get();

        model.addAttribute("product", p);

        System.out.println("from the showSampleView() ");
        return "listProduct";
    }
    @GetMapping("/")
    public String showAddProduct()
    {
        return "/addProduct";
    }

    @PostMapping("/addP")
    public String saveProduct(@RequestParam("pname") String name,
             @RequestParam("price") String price,
             @RequestParam("desc") String description)
    {
//        Product p = new Product();
//        p.setDesc(desc);
//        p.setName(name);
//        p.setPrice(price);
        return "redirect/listProduct";
    }

}
