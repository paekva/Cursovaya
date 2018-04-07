import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { IZoo, IAnimal } from './entites';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class AnimalService {

  private _urlAll: string /*= "http://localhost:8080/kursovaya_war_exploded/rest/animals/all";*/
  private _urlByZoo: string = "/assets/data/animals.json";

  constructor(private http:HttpClient) { }

  getAnimalsByZoo(zoo): Observable<IAnimal[]>{
    //this._urlByZoo + zoo;
    return this.http.get<IAnimal[]>(this._urlByZoo)
                    .catch(this.errorHandler);
  }
  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }

}