package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repositories.BoosterPacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
    private BoosterPacksRepository boosterPacksRepository;

    @Autowired

    public ProductServiceImpl(BoosterPacksRepository boosterPacksRepository) {
        this.boosterPacksRepository = boosterPacksRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) boosterPacksRepository.findAll();
    }

    @Override
    public Product findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Product> result = boosterPacksRepository.findById(theIdl);

        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(Product theProduct) {
        boosterPacksRepository.save(theProduct);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        boosterPacksRepository.deleteById(theIdl);
    }
    public List<Product> listAll(String keyword){
        if(keyword !=null){
            return boosterPacksRepository.search(keyword);
        }
        return (List<Product>) boosterPacksRepository.findAll();
    }
}
