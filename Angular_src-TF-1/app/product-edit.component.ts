import 'rxjs/add/operator/switchMap';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { Product } from './product';
import { ProductService } from './products.service';

@Component({
    selector: 'product-edit',
    templateUrl: './product-edit.component.html'
})

export class ProductEditComponent implements OnInit {

    constructor(
        private productService: ProductService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    @Input() product: Product;

    ngOnInit(): void {
        this.route.paramMap
            .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
            .subscribe(product => this.product = product);
    }

    save(): void {
        this.productService.update(this.product)
            .then(() => this.goBack());
    }

    goBack(): void {
        this.location.back();
    }

}