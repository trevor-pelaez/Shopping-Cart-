package com.example.demo.controllers;

import com.example.demo.repositories.BoosterPacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Product;

import java.util.Optional;


@Controller
public class BuyPackController {
    @Autowired
    private BoosterPacksRepository productRepo;

    @GetMapping("/buyPack")
    public String buyPack(@RequestParam("productID") long theId){
        Optional<Product> product = productRepo.findById(theId);
        if(product.isPresent()){
            Product tempProduct = product.get();
            if(tempProduct.getInv()>0){
                tempProduct.setInv(tempProduct.getInv()-1);
                productRepo.save(tempProduct);
                return "Success";
            } else {
                return "Failure";
            }
        } else {
            return "Failure";
        }
    }

    @GetMapping("Success")
    public String buySuccess(){
        return "Success";
    }

    @GetMapping("Failure")
    public String buyFail(){
        return "Failure";
    }





}

