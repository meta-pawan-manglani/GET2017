import { Injectable } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

/*
@author Pawan Manglani
@version 1.1 22-Sep-2017
*/

/*this class provide service to the application
This class read the list of product and send it to html page
*/
@Injectable ()
export class ProductService {
  
    private productUrl = 'http://localhost:8080/shoppingcart/rest/product/list';  // URL to web api
    private productAddUrl = 'http://localhost:8080/shoppingcart/rest/product/add'; // Add product URL
    private productGetByIdUrl = 'http://localhost:8080/shoppingcart/rest/product/get'; //Get product by id
    private productEdit = 'http://localhost:8080/shoppingcart/rest/product/edit'; //Url for edit
    private productDelete = 'http://localhost:8080/shoppingcart/rest/product/delete'; //Url for delete
   constructor(private http: Http) { }
    
   getProducts(): Promise<Product[]> {
     return this.http.get(this.productUrl)
                .toPromise()
                .then(response => response.json() as Product[])
                .catch(this.handleError);
   }
    
   private handleError(error: any): Promise<any> {
     console.error('An error occurred', error); // for demo purposes only
     alert('An error Occured'+error);
     return Promise.reject(error.message || error);
   }

   getProduct(id: number): Promise<Product> {
    const url = `${this.productGetByIdUrl}/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => 
        response.json().entity as Product
      )
      .catch(this.handleError);
  }

  private headers = new Headers({'Content-Type': 'application/json'});
  
  update(product: Product): Promise<Product> {
    const url = `${this.productEdit}/${product.id}`;
    return this.http
      .put(url, JSON.stringify(product), {headers: this.headers})
      .toPromise()
      .then(() => product)
      .catch(this.handleError);
  }

  create(name: string,price: number): Promise<Product> {
    return this.http
      .post(this.productAddUrl, JSON.stringify({name: name,price:price}), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Product)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.productDelete}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

}