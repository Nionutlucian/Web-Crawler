package com.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/search/{product}/{pageIndex}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Product> search(@PathVariable(value="product") String product
			,@PathVariable(value="pageIndex") String pageIndex) {
		try {
			return productService.searchProduct(product,Integer.valueOf(pageIndex));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
//	@RequestMapping(value="/search/{productCod}", method = RequestMethod.GET)
//	public @ResponseBody Product search(@PathVariable(value="productCod") String product) {
//		try {
//			return productService.getCelPrice(product);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
}