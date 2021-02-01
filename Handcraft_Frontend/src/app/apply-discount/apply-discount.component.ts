import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Product } from '../product';
import { ProducthubService } from '../producthub.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-apply-discount',
  templateUrl: './apply-discount.component.html',
  styleUrls: ['./apply-discount.component.css']
})
export class ApplyDiscountComponent implements OnInit {

  product=new Product();
  
  constructor( private router: Router,private productService:ProducthubService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void 
  {
    let id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    //let discountPercent = parseInt(this.activatedRoute.snapshot.paramMap.get('discountPercent'));
    this.productService.getProductById(id).subscribe(
                                                    Response=>{
                                                      console.log("data received");
                                                      console.log(Response);
                                                      this.product=Response;
                                                    },
                                                    error=>console.log("error")
                                                  )
    
  }


  applyDiscount(id:number,discount:number){
    this.productService.getProductByIdApplyDiscount(id,discount,this.product).subscribe(
      Response=>{
        console.log(discount);
        console.log("product updated successully");
        this.router.navigate(['/admin-product-list']);
      },
      error=>{
        console.log(error);
      }
    )
  }
}