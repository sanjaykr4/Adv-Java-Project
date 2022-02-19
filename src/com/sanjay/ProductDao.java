package com.sanjay;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProductDao {

	public boolean insertProduct(Product p) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		boolean flag = false;
		try {
			session.save(p);
			t.commit();
			flag = true;
		} catch (Exception e) {
		}

		return flag;

	}

	public Product searchProduct(int productId) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Product prod = (Product) session.get(Product.class, productId);

		return prod;
	}

	public boolean removeProduct(int productId) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Product prod = (Product) session.get(Product.class, productId);

		boolean flag = false;
		try {
			session.delete(prod);
			flag = true;
			t.commit();
		} catch (Exception e) {

		}

		return flag;
	}

	public boolean editProduct(int productId, int updatedQuantity) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Product prod = (Product) session.get(Product.class, productId);
		prod.setQuantity(updatedQuantity);
		boolean flag = false;
		try {
			session.update(prod);
			flag = true;
			t.commit();
		} catch (Exception e) {
		
		}
		return flag;
	}

	public List<Product> viewAll() {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		   Criteria prod = session.createCriteria(Product.class);
	       List<Product> prodlist = prod.list();
	       return prodlist;	
	}

}
