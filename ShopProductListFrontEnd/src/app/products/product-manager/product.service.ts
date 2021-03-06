import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import {Product} from '../../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl = '/api/';
  constructor(private http: HttpClient) { }

  getProductsForCurrentFamily(familyName: string): Observable<Array<Product>> {
    const params = new HttpParams().set('familyName', familyName);
    return this.http.get< Array<Product> >(this.productUrl + 'product', {params: params});
  }

  saveProductForCurrentFamily(product: Product, familyName: string): Observable<Product> {
    const params = new HttpParams().set('familyName', familyName);
    return this.http.post< Product >(this.productUrl + 'product', product, {params: params});
  }

}
