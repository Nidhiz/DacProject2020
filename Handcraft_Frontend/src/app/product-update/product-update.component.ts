import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProducthubService } from '../producthub.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {


  product=new Product();
  
  constructor( private router: Router,private productService:ProducthubService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.productService.getProductById(id).subscribe(
      Response=>{
        console.log("data received");
        this.product=Response;
      },
      error=>console.log("error")
    )   
  }

  updateProduct(){
    this.productService.addProductService(this.product).subscribe(
      Response=>{
        console.log("product updated successully");
        this.router.navigate(['/product-list']);
      },
      error=>{
        console.log(error);
      }
    )

  }

}
