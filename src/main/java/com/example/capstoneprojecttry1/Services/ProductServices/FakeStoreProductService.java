package com.example.capstoneprojecttry1.Services.ProductServices;

import com.example.capstoneprojecttry1.Exceptions.ProductNotFoundException;
import com.example.capstoneprojecttry1.Models.Category;
import com.example.capstoneprojecttry1.Models.Product;
import com.example.capstoneprojecttry1.dtos.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToNormalProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageUrl(fakeStoreProductDTO.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDTO.getCategory());

        return product;
    }
    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        //int a = 1 / 0;
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null) {
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }
        return convertFakeStoreProductToNormalProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOList  = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);

        List<Product> productList = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            productList.add(convertFakeStoreProductToNormalProduct(fakeStoreProductDTO));
        }
        return productList;
    }

    @Override
    public Product updateProduct(long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFakeStoreProductToNormalProduct(fakeStoreProductDTO1);
    }

    @Override
    public Product addNewProduct(Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());

        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDTO, FakeStoreProductDTO.class);
        return convertFakeStoreProductToNormalProduct(fakeStoreProductDTO1);
    }

    @Override
    public void deleteProduct(long productID) {
        restTemplate.delete("https://fakestoreapi.com/products/"+productID);
    }

    @Override
    public Product replaceProduct(long productID, Product product ) {
        return null;
    }
}
