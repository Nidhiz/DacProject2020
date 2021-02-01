import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../cart.service';
import { Product } from '../product';
import { ProducthubService } from '../producthub.service';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit {

  products: Product[];
  carts: any;

  productState: String;
  toastr: any;
  cartCount: number;
  
  constructor(private router: Router,private producthubService: ProducthubService, private cartService: CartService) { }

  ngOnInit(): void {
    this.loadCartCount();
    this.fetchProductList();
    
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

  fetchProductList(){
    this.producthubService.getProductsList().subscribe(
      response => {
        this.products=response;
          console.log(this.products)
        },
          error=>
          console.log("error")
    )
     }

  fetchProductList2(){
    this.producthubService.getProductsByState(this.productState).subscribe(
      response => {
        this.products=response;
          console.log(this.products)
        },
          error=>
          console.log("error"+error)
    )
        }

        onSearch() {
          console.log("product State",this.productState);
           this.fetchProductList2();
        }


        addToCart(product) {

        this.carts=new Cart(product,1,0);

          this.cartService
          .addCartItem(this.carts)
            .subscribe(response => {
              this.carts=response;
              console.log(this.carts)
          
                console.log("add to cart")
               // this.toastr.success('added your product to cart')
               this.router.navigate(["/cart"]);
              },
              error=>
              console.log("error"+error)   
            )
        }
      }
