package br.ind.grupojp.sce.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ind.grupojp.sce.business.ProductBusiness;
import br.ind.grupojp.sce.entities.Product;

@ManagedBean
@RequestScoped
public class ProductMB extends AbstractMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ProductBusiness productBusiness;

	private Product product;

	private List<Product> products;

	public ProductMB() {

		super();

		this.product = new Product();

	}

	public String save() {

		try {

			productBusiness.save(product);
			menssagemInfo("Cadastrado com Sucesso");
			product = new Product();

		} catch (Exception e) {
			e.printStackTrace();
			menssagemErro("Erro ao Cadastrar Produto");

		}

		return "/pages/protected/user/createProduct.xhtml";

	}

	

	public String delete(Product product) {

		try {

			productBusiness.delete(product);
			menssagemInfo("Deletado com Sucesso");

		} catch (Exception e) {

			menssagemErro("Erro ao deletar o produto, tente novamente.");

		}

		return "/pages/protected/user/products.xhtml";

	}

	public String update() {

			try {

			productBusiness.update(product);
			menssagemInfo("Editado com Sucesso");

		} catch (Exception e) {

			menssagemErro("Erro ao alterar o produto, tente novamente.");

		}

		return "/pages/protected/user/products.xhtml";

	}

	public ProductBusiness getProductBusiness() {
		return productBusiness;
	}

	public void setProductBusiness(ProductBusiness productBusiness) {
		this.productBusiness = productBusiness;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {

		this.products = productBusiness.getProducts();

		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	

}
