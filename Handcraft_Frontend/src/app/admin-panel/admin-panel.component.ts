import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user-service.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  userCount:number;
  productCount: number;
  supplierCount: number;
  constructor(private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
    this.loadUserCount();
    this.loadSupplierCount();
    this.loadProductCount();
  }

  loadUserCount(){
                  this.userService.getUserCount("ROLE_USER").subscribe( 
                                                          response=>{
                                                          console.log("response",+response);
                                                         this.userCount=response;
                                                         },
                                                        error=>console.log(error)
                                                      )

              }   
loadSupplierCount(){
                    this.userService.getUserCount("ROLE_SELLER").subscribe( 
                                                          response=>{
                                                          console.log("response",+response);
                                                           this.supplierCount=response;
                                                             },
                                                        error=>console.log(error)
                                                       )


}               

loadProductCount(){
                    this.userService.getProductCount().subscribe( 
                                                                 response=>{
                                                                  console.log("response",+response);
                                                                  this.productCount=response;
                                                                        },
                                                                  error=>console.log(error)
                                                                )


}
  
}


