package br.ind.grupojp.sce.repository;

import javax.ejb.Stateless;

import br.ind.grupojp.sce.entities.Product;

@Stateless
public class ProductJPA extends RepositoryJPA<Product, Long> implements ProductRepository{
	
	public ProductJPA() {
		super(Product.class);
	}	

}
