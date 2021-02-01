import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
 
  private baseUrl = 'http://localhost:7070/cart';

  constructor(private http: HttpClient) { }

  getCartItem(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getcartById(id: number): Observable<any>{
   return this.http.get(this.baseUrl+'/'+id);
  }

  addCartItem(cart: Object): Observable<Object> {
    return this.http.post(this.baseUrl, cart);
  }
  deleteCartItem(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/'+id);
  }
  updateCartItem(cart: Object): Observable<Object> {
    return this.http.put(this.baseUrl, cart);
  }

  deleteCart(): Observable<any> {
    return this.http.delete(this.baseUrl);
  }

  getCartCount(): Observable<any>{
    return this.http.get(this.baseUrl+'/cartCount');

  }

}
