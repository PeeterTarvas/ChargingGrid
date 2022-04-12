import { Injectable } from '@angular/core';
import {Laadimispunkt} from "../model/laadimispunkt";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LaadimispunktServiceService {

  constructor(private http: HttpClient) {}



  getAll(): Observable<Array<Laadimispunkt>> {
    return this.http.get<Array<Laadimispunkt>>('laadimispunkt');
  }
}
