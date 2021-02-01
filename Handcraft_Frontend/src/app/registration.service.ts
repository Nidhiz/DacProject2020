import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  
 
  private httpheader={headers: new HttpHeaders({'Content-type':'application/json'})}
  
  constructor(private http:HttpClient) { 
   
  }

  public loginUserFromRemote(user :User):Observable<any>{
    return this.http.post<any>("http://localhost:7070/login",user);
   
  }

  public registerUserFromRemote(user :User){
    return this.http.post("http://localhost:7070/registeruser",user,this.httpheader);
  }
}
