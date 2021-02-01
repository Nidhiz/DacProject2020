import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-user-panel',
  templateUrl: './user-panel.component.html',
  styleUrls: ['./user-panel.component.css']
})
export class UserPanelComponent implements OnInit {
  cartCount: number;

  constructor(private cartService:CartService) { }

  ngOnInit(): void {
    this.loadCartCount()
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
