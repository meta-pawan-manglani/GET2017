import { Component, OnInit }  from '@angular/core';
import { Product } from './product';
import 'rxjs/add/operator/switchMap';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';
import { ProductService } from './products.service'
@Component({
  selector: 'product-detail',
  templateUrl: `./product-detail.component.html`,
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit{
  product: Product;
  
    constructor(
      private productService: ProductService,
      private route: ActivatedRoute,
      private location: Location
    ) {}
  
    ngOnInit(): void {
      this.route.paramMap
        .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
        .subscribe(product => this.validate(product));    
    }
  

    validate(product: Product) {
      console.log(product);
      if(product == undefined) {
       alert("Invalid Url");
       this.goBack();
      }
      else {
        this.product = product;
      }

    }

    save(): void {
      this.productService.update(this.product)
        .then(() => this.goBack());
    }

    goBack(): void {
      this.location.back();
    }
}
