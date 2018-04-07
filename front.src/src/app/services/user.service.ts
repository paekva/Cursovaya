import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { IFullUser } from './entites';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class UserService {
  constructor(private http:HttpClient) { }

  getUserInfo(id): Observable<IFullUser>{
    const url="/assets/data/user.json";
    return this.http.get<IFullUser>(url)
                    .catch(this.errorHandler);
  }

  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }

}