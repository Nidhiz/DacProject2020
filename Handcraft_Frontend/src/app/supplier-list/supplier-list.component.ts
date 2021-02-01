import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user-service.service';

@Component({
  selector: 'app-supplier-list',
  templateUrl: './supplier-list.component.html',
  styleUrls: ['./supplier-list.component.css']
})
export class SupplierListComponent implements OnInit {

  users : User[];
  productService: any;

  constructor(private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
    this.loadUsers()
  }

  loadUsers() {
    this.userService
      .getSupplierList()
      .subscribe(response => {
          this.users = response
        } ,
        error=>{
          console.log("error "+error)
        }
      )
  }

  deleteSupplier(id: number) {
    var winResp =  window.confirm("Are you sure you want to delete?");
    if(winResp)
    {
      
      this.userService.deleteSupplierRemote(id).subscribe(
      
                                                      response=>{
                                                        console.log("response",+response);
                                                        
                                                      // window.location.reload();
                                                      //this.router.navigate(['/product-list'])
                                                      this.loadUsers();
                                                      },
                                                      error=>console.log(error)

                                                     )
      
    }      
  }
 
}
