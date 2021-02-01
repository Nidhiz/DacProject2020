import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-user-sale',
  templateUrl: './user-sale.component.html',
  styleUrls: ['./user-sale.component.css']
})
export class UserSaleComponent implements OnInit {
  cartCount: number;

  constructor( private cartService:CartService) { }

  ngOnInit(): void {
    this.loadCartCount();
  }
  loadCartCount(){
    this.cartService.getCartCount().subscribe( 
      response=>{
       console.log("response",+response);
       this.cartCount=response;
             },
       error=>console.log(error)
     )
  }

}
