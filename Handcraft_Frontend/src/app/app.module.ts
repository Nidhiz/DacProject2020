import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationComponent } from './registration/registration.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { ProductUpdateComponent } from './product-update/product-update.component';
import { UserPanelComponent } from './user-panel/user-panel.component';
import { SupplierPanelComponent } from './supplier-panel/supplier-panel.component';
import { GalleryComponent } from './gallery/gallery.component';
import { CartComponent } from './cart/cart.component';
import { ProductListComponent } from './product-list/product-list.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { FooterComponent } from './footer/footer.component';
import { SupplierListComponent } from './supplier-list/supplier-list.component';
import { ApplyDiscountComponent } from './apply-discount/apply-discount.component';
import { AdminProductListComponent } from './admin-product-list/admin-product-list.component';
import { LogoutComponent } from './logout/logout.component';
import { AdminReminderComponent } from './admin-reminder/admin-reminder.component';
import { OrderComponent } from './order/order.component';
import { UserSaleComponent } from './user-sale/user-sale.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HeaderComponent,
    HomeComponent,
    AboutusComponent,
    ContactusComponent,
    ProductAddComponent,
    ProductUpdateComponent,
    UserPanelComponent,
    SupplierPanelComponent,
    GalleryComponent,
    CartComponent,
    ProductListComponent,
    AdminPanelComponent,
    FooterComponent,
    SupplierListComponent,
    ApplyDiscountComponent,
    AdminProductListComponent,
    LogoutComponent,
    AdminReminderComponent,
    OrderComponent,
    UserSaleComponent
    ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
