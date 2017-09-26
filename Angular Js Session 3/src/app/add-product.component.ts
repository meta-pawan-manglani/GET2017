import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

import { Product } from './product';
import { ProductService } from './products.service';

@Component({
    selector: 'add-product',
    templateUrl: './add-product.component.html',
    styleUrls: ['./add-product.component.css']
})

export class AddProductComponent {
    products: Product[];
    selectedProduct: Product;

    constructor(
        private productService: ProductService,
        private router: Router,
        private location: Location
    ) { }

    add(name: string, price: number): void {
        name = name.trim();
        if (!name) { return; }
        this.productService.create(name, price)
            .then(product => {
                this.products.push(product);
                this.selectedProduct = null;
            });
        alert('Product Successfully Added !!');
    }
    goBack(): void {
        this.location.back();
      }
}