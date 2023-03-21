package com.CRUD.demoCRUD.validate;

import com.CRUD.demoCRUD.Constants;
import com.CRUD.demoCRUD.repository.CustomerRepository;
import com.CRUD.demoCRUD.repository.ProductRepository;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidate {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public ProductValidate(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

//    public ResponseStatus validateCode(UUID productId, String name) {
//        if (!StringUtils.hasText(name)) {
//            return ResponseStatus.EMPLOYEE_CODE_IS_NULL;
//        }
//        Pattern pattern = Pattern.compile(Constants.REGEX_CODE);
//        Matcher matcher = pattern.matcher(name);
//        if (!matcher.find()) {
//            return ResponseStatus.EMPLOYEE_CODE_WRONG_FORMAT;
//        }
//        if (productId == null && productRepository.existsByCode(name)) {
//            return ResponseStatus.EMPLOYEE_CODE_IS_EXIST;
//        }
//        return ResponseStatus.SUCCESS;
//    }
}
