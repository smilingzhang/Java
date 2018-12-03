package com.jd.shop.product.service;

import java.util.ArrayList;

import com.jd.shop.entity.Product;
import com.jd.shop.product.dao.ProductDao;

public class ProductService {

	public ProductService() {
		// TODO Auto-generated constructor stub
	}
    public ArrayList<Product> listPro(){
    	ProductDao p=new ProductDao();
    	return p.findAll();
    }
    public Product listById(String id) {
    	ProductDao p=new ProductDao();
    	return p.findById(id);
   
    }
}
