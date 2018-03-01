package com.franko.rest.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.franko.rest.dao.ProductDAO;
import com.franko.rest.models.Product;

@Component
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean enterProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.save(product);
		} catch(Exception e) {
			e.printStackTrace();
			session.close();
			return false;
		}

		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<Product> getProductDetails() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Product.class);
		return criteria.list();
	}

	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Product");
		List<Product> list = q.list();
		return list;
	}

	@Override
	public boolean deleteProduct(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Product product = new Product();
		product.setId(id);
		
		try {
			product = session.get(Product.class, id);
			session.delete(product);
		} catch(Exception e) {
			e.printStackTrace();
			session.close();
			return false;
		}

		session.getTransaction().commit();
		session.close();
		return true;
	}
}