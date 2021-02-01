import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user = new User();
  regmsg='';
  userError:User;
  isCreated:boolean=false;
  userExist:boolean=false;


  constructor(private service : RegistrationService,private router : Router) { }

  ngOnInit(): void {
  }

 
  onRegistrationclick(){
    this.service.registerUserFromRemote(this.user).subscribe
    (
        data=>
        {
          console.log(data);
          this.user=new User(); //reset fields
          this.isCreated=true;
          this.userExist=false;
          this.userError=new User();
          window.alert("Registration done !!");
        },
        error=>
        {
          this.userError=error.error; 
          this.isCreated=false;

          if(error.status == 409){
            this.isCreated=false;
            this.userExist=true;
            this.userError=new User();
           // this.user=new User();
          }
         console.log("Exception:{}",error);       
        }
    )
}
}
