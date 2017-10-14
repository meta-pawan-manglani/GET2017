import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';
import { ProductService } from './products.service';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

/*This is the app component one can show it anywhere by using product-list tag*/
@Component({
selector: 'product-list',
templateUrl: './product.component.html',
styleUrls: ['./product.component.css']
})

/*as soon as the url is hit this will call the service and load te data of products*/
export class ProductComponent implements OnInit {
title = 'Products';
products = PRODUCTS;
selectedProduct: Product;
constructor(private  router: Router,
  private productService: ProductService) {}

ngOnInit() {
this.getProducts();
}

getProducts(): void {
this.productService.getProducts().then(products => this.products = products.slice(1));
}

onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedProduct.id]);
  }
  
  gotoAddProduct(): void {
    this.router.navigate(['/addproduct']);
  }
  
  delete(product: Product): void {
    this.productService
        .delete(product.id)
        .then(() => {
          this.products = this.products.filter(h => h !== product);
          if (this.selectedProduct === product) { this.selectedProduct = null; }
        });
  }
  
  
}