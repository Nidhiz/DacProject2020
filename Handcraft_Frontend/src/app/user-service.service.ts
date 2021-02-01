import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  
  private baseUrl = 'http://localhost:7070';

  constructor( private httpClient: HttpClient) { }

  getSupplierList(): Observable<any> {
    return this.httpClient.get(this.baseUrl+'/admin/role/ROLE_SELLER');
  }

 
    deleteSupplierRemote(id: number): Observable<any> {
      return this.httpClient.delete(this.baseUrl+'/admin/'+id);
    }

    getUserCount(role:string): Observable<any>{
      return this.httpClient.get(this.baseUrl+'/admin/roleCount/'+role);

    }

    getProductCount(): Observable<any>{
      return this.httpClient.get(this.baseUrl+'/admin/productCount');

    }

}
