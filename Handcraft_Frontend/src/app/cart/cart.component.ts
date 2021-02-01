import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../cart.service';
import { Product } from '../product';
import { ProducthubService } from '../producthub.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  totalCartAmount = 0.0
  carts:Cart[]
  product:Product;
  cartCount:number;

  constructor(
   private router:Router,
    private productService: ProducthubService,
    private cartService: CartService,private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadCartCount()
   this.loadCartItems()  
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

  loadCartItems() {
    //console.log("hello");
    this.cartService
      .getCartItem()
      .subscribe(response => {
        
          this.carts = response
          console.log("Cart Items"+this.carts);
          this.totalCartAmount = 0
          for (let index = 0; index < this.carts.length; index++) {
            console.log(this.carts.length);
            const cart = this.carts[index];
            this.totalCartAmount += parseFloat(cart['totalAmount'])
          }
        
      })
  }

  onPlaceOrder(totalCartAmount){
    this.router.navigate(['/order',totalCartAmount]);
  }

  onAddMore(){
    this.router.navigate(['/gallery']);

  }
  onDelete(cart) {
    this.cartService
      .deleteCartItem(cart['cartId'])
      .subscribe(response => {
        console.log("cart Item delete");
          this.loadCartItems()
        
      })
  }
  updateQuantity(quantity, cart) {
    const newQuantity = cart['quantity'] + quantity
    console.log("quantity "+newQuantity)

    cart['quantity']=newQuantity;
    cart['totalAmount'] = cart['quantity']*cart.product['price'];

    if (newQuantity == 0) {
      this.onDelete(cart)
    } else {
      this.cartService
        .updateCartItem(cart)
        .subscribe(response => {
          //this.carts = response;
          console.log(response);
            console.log("updated quantity")
            //this.success('updated quantity')
          // this.carts=response;
            this.loadCartItems()
          
        })
    }
  }
}



