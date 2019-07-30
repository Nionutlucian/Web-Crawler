package com.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.model.Product;

import handler.HtmlHandler;

@Service
public class ProductService {

	HtmlHandler handlerHtml;
	
	public ArrayList<Product> searchProduct(String searchedProduct,int pageIndex) throws IOException {
		handlerHtml  = new HtmlHandler("https://www.emag.ro/search/" + searchedProduct + "/p" + pageIndex);
		return handlerHtml.test();
	}
	
//	public Product getCelPrice(String codProd) throws IOException {
//		handlerHtml  = new HtmlHandler("https://www.emag.ro/search/");
//		return handlerHtml.getCelPrice(codProd);
//	}
	
	
}
