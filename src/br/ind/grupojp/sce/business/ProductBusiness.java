package br.ind.grupojp.sce.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ind.grupojp.sce.entities.Product;
import br.ind.grupojp.sce.repository.ProductRepository;

@Stateless
public class ProductBusiness {

	@EJB
	private ProductRepository productRepository;
	
	private List<Product> products;

	public void save(Product product) {

		productRepository.save(product);

	}

	public void update(Product product) {

		productRepository.update(product);

	}

	public void delete(Product product) {

		productRepository.delete(product.getId(), Product.class);

	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getProducts() {
	
			this.products = this.productRepository.findAll();
				
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
