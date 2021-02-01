import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProducthubService } from '../producthub.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  product= new Product();

  constructor( private router: Router,private productService:ProducthubService) { }

  ngOnInit(): void {
  }


  addProduct(){
    this.productService.addProductService(this.product).subscribe(
                                                                  Response=>{
                                                                    console.log("product inserted successully");
                                                                    this.router.navigate(['/product-list']);
                                                                  },
                                                                  error=>{
                                                                    console.log(error);
                                                                  }
                                                                )

  }

}
