import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  totalAmount:number;
  cartCount: number;
  constructor(private router: Router,private activatedRoute: ActivatedRoute,private cartService: CartService) { }

  ngOnInit(): void {
    this.loadCartCount();
    let totalAmount = parseInt(this.activatedRoute.snapshot.paramMap.get('totalCartAmount'));
    console.log("amount="+totalAmount);
    this.totalAmount=totalAmount;
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
  onCheckOut(){
    this.cartService
    .deleteCart()
    .subscribe(response => {
      console.log("delete All cart")    
      this.router.navigate(['/cart']);
    })
}
    
}


