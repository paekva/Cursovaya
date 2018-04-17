import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { IZoo } from './entites';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class AnimalService {

  private _url /*= "http://localhost:8080/kursovaya_war_exploded/rest/animals/all";*/
  = '/assets/data/zoo.json';

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<IZoo[]> {
    return this.http.get<IZoo[]>(this._url)
                    .catch(this.errorHandler);
  }
  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error');
  }

}
