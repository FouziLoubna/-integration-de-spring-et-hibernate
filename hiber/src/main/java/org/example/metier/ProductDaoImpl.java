package org.example.metier;

import org.example. dao.IDao;
import org.example.entities.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        return true;
    }

    @Override
    public boolean delete(Product product) {

            Session session = sessionFactory.getCurrentSession();
            delete(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        Session session = sessionFactory.getCurrentSession();
            session.update(product);
            return true;
    }

    @Override
    public Product findById(int id) {
        Product product  = null;
        Session session = sessionFactory.getCurrentSession();

        product = (Product) session.get(Product.class, id);

            return product  ;

    }

    @Override
    public List<Product> findAll() {
        List<Product>  product  = null;
        Session session = sessionFactory.getCurrentSession();

        return product;
    }

}