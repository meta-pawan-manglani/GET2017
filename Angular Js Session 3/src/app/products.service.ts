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
    private productUrl = 'api/PRODUCTS';  // URL to web api
    
   constructor(private http: Http) { }
    
   getProducts(): Promise<Product[]> {
     return this.http.get(this.productUrl)
                .toPromise()
                .then(response => response.json().data as Product[])
                .catch(this.handleError);
   }
    
   private handleError(error: any): Promise<any> {
     console.error('An error occurred', error); // for demo purposes only
     return Promise.reject(error.message || error);
   }

   getProduct(id: number): Promise<Product> {
    const url = `${this.productUrl}/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json().data as Product)
      .catch(this.handleError);
  }

  private headers = new Headers({'Content-Type': 'application/json'});
  
  update(product: Product): Promise<Product> {
    const url = `${this.productUrl}/${product.id}`;
    return this.http
      .put(url, JSON.stringify(product), {headers: this.headers})
      .toPromise()
      .then(() => product)
      .catch(this.handleError);
  }

  create(name: string,price: number): Promise<Product> {
    return this.http
      .post(this.productUrl, JSON.stringify({name: name,price:price}), {headers: this.headers})
      .toPromise()
      .then(res => res.json().data as Product)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.productUrl}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

}