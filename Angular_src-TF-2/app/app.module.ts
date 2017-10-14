import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { ProductComponent } from './product.component';

import { ProductService } from './products.service';

import { FormsModule } from '@angular/forms';

import { ProductDetailComponent } from './product-detail.component';

import { HttpModule }    from '@angular/http';

import { DashboardComponent } from './dashboard.component';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';

import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';

import { AddProductComponent } from './add-product.component';

import { ProductSearchComponent } from './product-search.component';

import { ProductEditComponent } from './product-edit.component';

import { ContactUsComponent } from './contact-us.component';
@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ProductDetailComponent,
    ProductComponent,
    AddProductComponent,
    ProductSearchComponent,
    ProductEditComponent,
    ContactUsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})


export class AppModule { }
