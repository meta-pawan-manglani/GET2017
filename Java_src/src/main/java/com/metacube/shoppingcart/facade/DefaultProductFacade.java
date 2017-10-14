package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.ProductService;


/**
 *  @author Pawan Manglani
 *  @version 1.1 27-Sep-2017
 * 
 * The Class DefaultProductFacade.
 */
public class DefaultProductFacade implements ProductFacade {

	/** The product service. */
	ProductService productService;

	/**
	 * Instantiates a new default product facade.
	 *
	 * @param productService the product service
	 */
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.ProductFacade#getAllProducts()
	 */
	@Override
	public Iterable<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.ProductFacade#getProductById(int)
	 */
	@Override
	public ProductDto getProductById(int id) {
		// TODO Auto-generated method stub
		return modelToDto(productService.getProductById(id));
	}



	/**
	 * Dto to model.
	 *
	 * @param productDto the product dto
	 * @return the product
	 */
	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product user = new Product();
		user.setId(productDto.getId());
		user.setName(productDto.getName());
		user.setPrice(productDto.getPrice());
		return user;
	}

	/**
	 * Model to dto.
	 *
	 * @param product the product
	 * @return the product dto
	 */
	protected ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.ProductFacade#addProduct(com.metacube.shoppingcart.modal.Product)
	 */
	@Override
	public Status addProduct(Product entity) {
		// TODO Auto-generated method stub
		return productService.addProduct(entity);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.ProductFacade#deleteProduct(int)
	 */
	public Status deleteProduct(int id) {
		return  productService.deleteProduct(id);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.facade.ProductFacade#editProduct(com.metacube.shoppingcart.modal.Product, int)
	 */
	@Override
	public Status editProduct(Product entity,int id) {
		// TODO Auto-generated method stub
		return productService.editProduct(entity,id);
	}
}
