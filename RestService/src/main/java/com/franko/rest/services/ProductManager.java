package com.franko.rest.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.franko.rest.models.Product;

public class ProductManager {
	protected SessionFactory sessionFactory;

	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			if(sessionFactory == null) {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			}
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	protected void exit() {
		sessionFactory.close();
	}

	protected void create() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Product product = new Product();
		product.setName("Shampoo");
		product.setBrand("Biolage");
		product.setWholeSalePrice(9.99f);
		product.setSalePrice(19.99f);

		session.save(product);

		session.getTransaction().commit();
		session.close();
	}

	protected void read() {
		Session session = sessionFactory.openSession();

		long productId = 1;
		Product product = session.get(Product.class, productId);
		System.out.println("Name: " + product.getName());
		System.out.println("Sale Price: " + product.getSalePrice());
	}

	protected void update(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(product);

		session.getTransaction().commit();
		session.close();
	}

	protected void delete(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(product);

		session.getTransaction().commit();
		session.close();
	}
}