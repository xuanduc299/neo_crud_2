package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.dto.ProductDTO;
import com.CRUD.demoCRUD.dto.Response;
import com.CRUD.demoCRUD.entity.Product;
import com.CRUD.demoCRUD.repository.ProductRepository;
import com.CRUD.demoCRUD.service.ProductService;
import com.CRUD.demoCRUD.convert.Convert;
import com.CRUD.demoCRUD.validate.ResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final Convert convert;

    public ProductServiceImpl(ProductRepository productRepository, Convert convert) {
        this.productRepository = productRepository;
        this.convert = convert;
    }

    @Override
    public Response<List<ProductDTO>> getAll() {
        List<Product> product = productRepository.findAll();
        List<ProductDTO> productDto = new ArrayList<>();
        productRepository.findAll().forEach(products -> productDto.add(new ProductDTO(products)));
        return new Response<>(productDto);
    }
    @Override
    public Response<List<ProductDTO>> getByName(String name) {
        List<Product> product = productRepository.search(name);
        List<ProductDTO> productDto = new ArrayList<>();
        productRepository.search(name).forEach(products -> productDto.add(new ProductDTO(products)));
        return new Response<>(productDto);
    }

    @Override
    public Response<ProductDTO> getById(UUID id) {
        Product product = productRepository.getProductById(id);
        return new Response<>(new ProductDTO(product),ResponseStatus.SUCCESS);
    }

    @Override
    public Response<ProductDTO> create(ProductDTO dto) {
        Product product = new Product();
        convert.convertDataIntoDTO((ProductDTO) dto,product);
        product = productRepository.save(product);
        return new Response<>(new ProductDTO(product),ResponseStatus.SUCCESS);
    }

    @Override
    public Response<ProductDTO> edit(ProductDTO dto, UUID id) {
        Product product = productRepository.getProductById(id);
        convert.convertDataIntoDTO(dto,product);
        product = productRepository.save(product);
        return new Response<>(new ProductDTO(product),ResponseStatus.SUCCESS);
    }

    @Override
    public Response<Boolean> delete(UUID id) {
        productRepository.deleteById(id);
        return new Response<>(ResponseStatus.SUCCESS);
    }


}
