import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProducthubService {

  private baseUrl = 'http://localhost:7070';

  constructor(private http: HttpClient) { }

  getProductsList(): Observable<any> {
    return this.http.get(this.baseUrl+'/products/');
  }

  addProductService(product: Object): Observable<Object> {
    return this.http.post(this.baseUrl+'/products/', product);
  }

  updateProduct(product: Object): Observable<Object> {
    return this.http.put(this.baseUrl+'/products/', product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/products/'+id);
  }

  getProductById(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/products/'+id);
  }

  getProductsByState(productState:String): Observable<any> {
    return this.http.get(this.baseUrl + '/products/state/'+productState);
  }


 getProductByIdApplyDiscount(id: number,discount : number,product: Object): Observable<Object> {
    return this.http.put(this.baseUrl+'/admin/'+id+'/'+discount,product);
  }

  
}