package com.klu;

import com.main.Product;
import com.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.query.Query;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Insert Records
        session.persist(new Product("Pen","Stationery",10,50));
        session.persist(new Product("Book","Stationery",120,20));
        session.persist(new Product("Mouse","Electronics",450,15));
        session.persist(new Product("Keyboard","Electronics",700,8));
        session.persist(new Product("Bottle","Plastic",80,0));
        session.persist(new Product("Bag","Fashion",900,5));

        System.out.println("Products Inserted");

        // Sort Price Asc
        Query<Product> q1 = session.createQuery(
                "from Product p order by p.price asc",Product.class);
        System.out.println("Price Ascending");
        q1.list().forEach(p-> System.out.println(p.getName()+" "+p.getPrice()));

        // Sort Price Desc
        Query<Product> q2 = session.createQuery(
                "from Product p order by p.price desc",Product.class);
        System.out.println("Price Descending");
        q2.list().forEach(p-> System.out.println(p.getName()+" "+p.getPrice()));

        // Sort Quantity
        Query<Product> q3 = session.createQuery(
                "from Product p order by p.quantity desc",Product.class);
        System.out.println("Quantity Highest");
        q3.list().forEach(p-> System.out.println(p.getName()+" "+p.getQuantity()));

        // Pagination First 3
        Query<Product> q4 = session.createQuery("from Product",Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);
        System.out.println("First 3 Products");
        q4.list().forEach(p-> System.out.println(p.getName()));

        // Pagination Next 3
        Query<Product> q5 = session.createQuery("from Product",Product.class);
        q5.setFirstResult(3);
        q5.setMaxResults(3);
        System.out.println("Next 3 Products");
        q5.list().forEach(p-> System.out.println(p.getName()));

        // Aggregate
        Long total = (Long) session.createQuery(
                "select count(p) from Product p").uniqueResult();
        System.out.println("Total Products = "+total);

        Long available = (Long) session.createQuery(
                "select count(p) from Product p where p.quantity>0").uniqueResult();
        System.out.println("Available Products = "+available);

        Object[] price = (Object[]) session.createQuery(
                "select min(p.price), max(p.price) from Product p").uniqueResult();
        System.out.println("Min Price="+price[0]+" Max Price="+price[1]);

        // Group By
        List<Object[]> list = session.createQuery(
                "select p.description,count(p) from Product p group by p.description"
        ).list();

        System.out.println("Group By Description");
        for(Object[] row:list)
            System.out.println(row[0]+" "+row[1]);

        // Price Range
        Query<Product> q6 = session.createQuery(
                "from Product p where p.price between 100 and 800",Product.class);
        System.out.println("Price Range");
        q6.list().forEach(p-> System.out.println(p.getName()));

        // LIKE
        System.out.println("Starts with M");
        session.createQuery(
                "from Product p where p.name like 'M%'",Product.class)
                .list().forEach(p-> System.out.println(p.getName()));

        System.out.println("Ends with e");
        session.createQuery(
                "from Product p where p.name like '%e'",Product.class)
                .list().forEach(p-> System.out.println(p.getName()));

        System.out.println("Contains oo");
        session.createQuery(
                "from Product p where p.name like '%oo%'",Product.class)
                .list().forEach(p-> System.out.println(p.getName()));

        System.out.println("Length 4");
        session.createQuery(
                "from Product p where length(p.name)=4",Product.class)
                .list().forEach(p-> System.out.println(p.getName()));

        tx.commit();
        session.close();
        factory.close();
    }
}