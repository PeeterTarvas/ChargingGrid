import { Injectable } from '@angular/core';
import {Laadimispunkt} from "../model/laadimispunkt";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LaadimispunktServiceService {

  constructor(private http: HttpClient) {}



  getAll(): Observable<Laadimispunkt[]> {
    return this.http.get<Laadimispunkt[]>('laadimispunkt');
  }
}
