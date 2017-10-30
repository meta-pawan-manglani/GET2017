import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard.component';
import { ProductsComponent } from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { ContactUsComponent } from './contact-us.component';
import { AddProductComponent } from './add-product.component';
import { GetProductDetailComponent } from './get-product-detail.component';
import { Cart } from './Cart';
import { LoginComponent } from './login-component';

const routes: Routes = [
  { path: '', component:LoginComponent},
  { path: 'dashboard',  component: DashboardComponent },
  { path: 'detail/:id', component: ProductDetailComponent },
  { path: 'productsList', component: ProductsComponent },
  { path: 'contactUs', component: ContactUsComponent },
  { path: 'addProduct', component: AddProductComponent },
  { path: 'getProductDetail/:id', component: GetProductDetailComponent },
  { path: 'cart', component: Cart },

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
