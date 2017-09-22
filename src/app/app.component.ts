import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';
import { ProductService } from './products.service';

/*This is the app component one can show it anywhere by using product-list tag*/
@Component({
selector: 'product-list',
templateUrl: './app.component.html',
styleUrls: ['./app.component.css']
})

/*as soon as the url is hit this will call the service and load te data of products*/
export class AppComponent implements OnInit {
title = 'Products';
products = PRODUCTS;
constructor(private productService: ProductService) {}

ngOnInit() {
this.getProducts();
}

getProducts(): void {
this.productService.getProducts().then(products => this.products = products);
}
}