import { InMemoryDbService } from 'angular-in-memory-web-api';
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const PRODUCTS = [
        { id:0, name:'Zero', price:0},
        { id: 11, name: 'Reebok Sneakers', price:2500 },
        { id: 12, name: 'Reebok Shoes ', price:2549 },
        { id: 13, name: 'Bata Shoes', price:1300 },
        { id: 14, name: 'US Polo Tshirt', price:1333 },
        { id: 15, name: 'Reebok Shorts', price:999 },
        { id: 16, name: 'Wrangler Jeans', price:99 },
        { id: 17, name: 'Reebok Pullover', price:2215 },
        { id: 18, name: 'Puma Shoes ', price:2775 },
        { id: 19, name: 'Puma Pullover', price:465 },
        { id: 20, name: 'Adidas Shoes', price:1976 }
    ];
    return {PRODUCTS};
  }
}