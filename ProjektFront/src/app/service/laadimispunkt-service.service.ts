import { Injectable } from '@angular/core';
import {Laadimispunkt} from "../model/laadimispunkt";
import {catchError, map, Observable, throwError} from "rxjs";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LaadimispunktServiceService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<Laadimispunkt[]> {
    return this.http.get<Laadimispunkt[]>('/laadimispunkt')
      .pipe(map((data: any) => data), catchError(this.handleError));
  }

  get(id: bigint): Observable<Laadimispunkt> {
    return this.http.get<Laadimispunkt>('/laadimispunkt/' + `${id}`)
      .pipe(map((data: any) => data), catchError(this.handleError))
  }


  private handleError(res: HttpErrorResponse | any) {
    console.error(res.error || res.body.error);
    return throwError(res.error || 'Server error');
  }
}
