import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard.component';
import { ProductComponent } from './product.component';
import { ProductDetailComponent } from './product-detail.component';
import { AddProductComponent } from './add-product.component';
import { ProductEditComponent } from './product-edit.component';
import { ContactUsComponent } from './contact-us.component';

const routes: Routes = [
{ path: '', redirectTo: '/dashboard', pathMatch: 'full' },
{ path: 'dashboard', component: DashboardComponent },
{ path: 'detail/:id', component: ProductDetailComponent },
{ path: 'productList', component: ProductComponent },
{ path: 'addproduct', component: AddProductComponent},
{ path: 'product-edit/:id', component: ProductEditComponent},
{ path: 'contactUs', component: ContactUsComponent},
{ path: 'inavlidPath', redirectTo: '/dashboard'},
{ path: '**',redirectTo:'/404'}
];

@NgModule({
imports: [ RouterModule.forRoot(routes) ],
exports: [ RouterModule ]
})
export class AppRoutingModule {}