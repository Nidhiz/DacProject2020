import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();
  msg='';


  constructor(private service : RegistrationService,private router : Router) { }

  ngOnInit(): void {

  }

  onLogin()
  {
    this.service.loginUserFromRemote(this.user).subscribe
                                                (
                                                    responseData=>
                                                    {
                                                      console.log("response received");
                                                      //console.log(this.user.address);
                                                      console.log("role:" + responseData.role);
                                                     if(responseData.role=="ROLE_USER")
                                                      this.router.navigate(["/user-panel"]);
                                                      else
                                                      if(responseData.role=="ROLE_SELLER")
                                                      this.router.navigate(["/supplier-panel"]);
                                                      else
                                                      if(responseData.role=="ROLE_ADMIN")
                                                      this.router.navigate(["/admin-panel"]);
                                                    

                                                    },
                                                    error=>
                                                    {console.log("Exception");
                                                    this.msg="Bad Credentials, Please enter valid email Or password";
                                                   }

                                                 )

  }
  onRegistration(){
  this.router.navigate(["/registration"]);
  }

}
/* form validation**
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, FormArray } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit  {
  loginForm: FormGroup;
  user = new User();
  msg='';


  constructor(private service : RegistrationService,private router : Router) {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required])
    });
  }
  ngOnInit(): void {
    
  }

  onLogin() {
    if(this.loginForm.valid) {
      this.service.loginUserFromRemote(this.user).subscribe
                                                (
                                                    responseData=>
                                                    {
                                                      console.log("response received");
                                                      console.log(this.user.address);
                                                      console.log("role:" + responseData.role);
                                                     if(responseData.role=="ROLE_USER")
                                                      this.router.navigate(["/user-panel"]);
                                                      else
                                                      if(responseData.role=="ROLE_SELLER")
                                                      this.router.navigate(["/supplier-panel"]);


                                                    },
                                                    error=>
                                                    {console.log("Exception");
                                                    this.msg="Bad Credentials, Please enter valid email Or password";
                                                   }

                                                 )

    }
  }
 
}*/

