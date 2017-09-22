import { Injectable } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';
/*
@author Pawan Manglani
@version 1.1 22-Sep-2017
*/

/*this class provide service to the application
This class read the list of product and send it to html page
*/
@Injectable ()
export class ProductService {
    getProducts(): Promise<Product[]> {
        return Promise.resolve(PRODUCTS);
    }
}