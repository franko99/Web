package com.franko.rest.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.franko.rest.models.Person;

public class PersonManager {
	private static SessionFactory sessionFactory;
	
//	public static void main(String[] args) {
//		getSessionFactory();
//		System.out.println("hi");
//	}

	private static void getSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			if (sessionFactory == null) {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			}
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	private static void exit() {
		sessionFactory.close();
	}

	protected static boolean create(Person person) {
		try {
			getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(person);

			session.getTransaction().commit();
			session.close();
			exit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected static void read() {
		getSessionFactory();
		exit();
	}

	protected static void update() {
		getSessionFactory();
		exit();
	}

	protected static void delete() {
		getSessionFactory();
		exit();
	}
}