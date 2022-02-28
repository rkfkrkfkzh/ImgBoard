package service;

import java.util.ArrayList;

import model.Product;
import dao.Dao;
import dao.DaoImpl;


public class ServiceImpl implements Service {
	private Dao dao;

	public ServiceImpl() {
		this.dao = new DaoImpl();
	}

	public void add(Product p) {
		// TODO Auto-generated method stub
		dao.insert(p);
	}

//	public ArrayList<Product> getProductsById(String s_id) {
//		// TODO Auto-generated method stub
//		return dao.selectAllById(s_id);
//	}

	public Product getProduct(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	public void editProduct(Product p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void delProduct(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	public int makeNum() {
		// TODO Auto-generated method stub
		return dao.selectNum();
	}

	public ArrayList<Product> getProductAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public Product editQuantity(int q, int num) {
		// TODO Auto-generated method stub
		dao.updateQuantity(q, num);
		return getProduct(num);
	}

}
