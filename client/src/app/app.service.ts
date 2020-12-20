import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AppService {
    apiUrl: string ;
    constructor(private http: HttpClient) {
        this.apiUrl = "http://localhost:8080/"
     }

    fetchAllEvents() {
        return this.http.get(this.apiUrl + "fetch-events");
    }

}