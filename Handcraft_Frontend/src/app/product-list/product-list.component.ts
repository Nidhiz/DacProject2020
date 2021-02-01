import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from '../product';
import { ProducthubService } from '../producthub.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  constructor(
    private router: Router,private productService:ProducthubService) { }

  ngOnInit() {
    this.fetchProductList();
    
  }

  fetchProductList(){
    this.productService.getProductsList().subscribe(
      response => {
        this.products=response;
          console.log(this.products)
        },
          error=>
          console.log("error")
    )
        }
  

  onEdit(id: number) {
    console.log("ProductId",+id);
    this.router.navigate(['/product-update',id]);
  }


  addProduct() {
    this.router.navigate(['/product-add'])
  }


  onDelete(id: number) {
    var winResp =  window.confirm("Are you sure you want to delete?");
    if(winResp)
    {
      
      this.productService.deleteProduct(id).subscribe(
      
                                                      response=>{
                                                        console.log("response",+response);
                                                        
                                                      // window.location.reload();
                                                      //this.router.navigate(['/product-list'])
                                                      this.fetchProductList();
                                                      },
                                                      error=>console.log(error)

                                                     )
      
    }    
    
   
  }

}