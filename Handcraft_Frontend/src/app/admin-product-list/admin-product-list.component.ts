import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProducthubService } from '../producthub.service';

@Component({
  selector: 'app-admin-product-list',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.css']
})
export class AdminProductListComponent implements OnInit {

  products: Product[];
  constructor(
    private router: Router,private productService:ProducthubService) { }

  ngOnInit() {
    this.fetchProductList();
    
  }

  fetchProductList()
  {
    this.productService.getProductsList().subscribe(
                                                    response => {
                                                      this.products=response;
                                                        console.log(this.products)
                                                      },
                                                        error=>
                                                        console.log("error")
                                                  )
     }

     onDiscount(id: number) 
     {
      console.log("ProductId",+id);
      this.router.navigate(['/apply-discount',id]);
    }
}