import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { AdminProductListComponent } from './admin-product-list/admin-product-list.component';
import { AdminReminderComponent } from './admin-reminder/admin-reminder.component';
import { ApplyDiscountComponent } from './apply-discount/apply-discount.component';
import { CartComponent } from './cart/cart.component';
import { ContactusComponent } from './contactus/contactus.component';
import { GalleryComponent } from './gallery/gallery.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { OrderComponent } from './order/order.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductUpdateComponent } from './product-update/product-update.component';
import { RegistrationComponent } from './registration/registration.component';
import { SupplierListComponent } from './supplier-list/supplier-list.component';
import { SupplierPanelComponent } from './supplier-panel/supplier-panel.component';
import { UserPanelComponent } from './user-panel/user-panel.component';
import { UserSaleComponent } from './user-sale/user-sale.component';

const routes: Routes = [

  {path:'', redirectTo:'home', pathMatch:'full'},

  {path:'home', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'logout',component:LogoutComponent},
  {path:'registration',component:RegistrationComponent},
  {path:'aboutus', component: AboutusComponent},
  {path:'contactus', component: ContactusComponent},
  
  {path:'user-panel', component: UserPanelComponent},
  {path:'cart', component: CartComponent},
  {path:'gallery', component: GalleryComponent},
  {path:'cart/:id', component: CartComponent},
  {path:'order/:totalCartAmount', component: OrderComponent},
  {path:'order', component: OrderComponent},
  {path:'user-sale', component: UserSaleComponent},

  {path:'supplier-panel', component: SupplierPanelComponent},
  // {path:'product/:id', component: ProductComponent},
  {path:'product-list', component: ProductListComponent},
  {path:'product-add', component:ProductAddComponent},
  {path:'product-update', component:ProductUpdateComponent},
  {path:'product-update/:id', component:ProductUpdateComponent},
  

  {path:'admin-panel', component: AdminPanelComponent},
  {path:'admin-product-list', component:AdminProductListComponent},
  {path:'supplier-list', component:SupplierListComponent},
  {path:'apply-discount', component:ApplyDiscountComponent},
  {path:'apply-discount/:id', component:ApplyDiscountComponent},
  {path:'apply-discount/:id/:discountPercent', component:ApplyDiscountComponent},
  {path:'admin-reminder', component: AdminReminderComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
