import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ConnectionService {

  constructor(private httpClient: HttpClient) { }

  public get(api_path: String) {
    let get = 'http://localhost:8080/api' + api_path;
    console.log(get)
    return this.httpClient.get(get);
  }


}
