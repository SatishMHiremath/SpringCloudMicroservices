package com.test.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.productservice.model.Coupon;
import com.test.productservice.model.Product;
import com.test.productservice.repo.ProductRepo;
import com.test.productservice.restclients.CouponClient;

@RestController
@RequestMapping("/productapi")
@RefreshScope
public class ProductController {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CouponClient couponClient;
	
	@Value("${com.test.productservice.springcloud.prop}")
	private String prop;
	
	@GetMapping("/prop")
	public String getProp() {
		return prop;
	}
	
	@HystrixCommand(fallbackMethod="sendErrorResponse")
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public Product createCoupon(@RequestBody Product product) {
		
		Coupon coupon =couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return productRepo.save(product);	
	}
	
	public Product sendErrorResponse(Product product) {
		return product;
	}

	@GetMapping("/allproducts")
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
}
