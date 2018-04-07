import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { IZoo, IZoos, IAnimal, IType, ITickets, IFullUser, IEmployee } from './entites';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class ZooService {

  private _url: string /*= "http://localhost:8080/kursovaya_war_exploded/rest/zoo/all";*/
  = "/assets/data/zoo.json";
  private _urlByZoo: string = "/assets/data/animals.json";

  constructor(private http:HttpClient) { }

  getUserInfo(id): Observable<IFullUser>{
    const url="/assets/data/user.json";
    return this.http.get<IFullUser>(url)
                    .catch(this.errorHandler);
  }

  getZoos(): Observable<IZoos[]>{
    return this.http.get<IZoos[]>(this._url)
                    .catch(this.errorHandler);
  }

  getZooById(zooId): Observable<IZoo>{
    const url = "/assets/data/oneZoo.json";
    //url = url + "/" + zooId
    return this.http.get<IZoo>(url)
                    .catch(this.errorHandler);
  }

  getAnimalsByZoo(zoo): Observable<IAnimal[]>{
    //this._urlByZoo + zoo;
    return this.http.get<IAnimal[]>(this._urlByZoo)
                    .catch(this.errorHandler);
  }

  getEmployeesByZoo(zoo): Observable<IEmployee[]>{
    //this._urlByZoo + zoo;    
    const url = "/assets/data/employees.json"; 
    return this.http.get<IEmployee[]>(url)
                    .catch(this.errorHandler);
  }


  getAnimalTypes(): Observable<IType[]>{
    const url = "/assets/data/animalTypes.json"; 
    return this.http.get<IType[]>(url)
                    .catch(this.errorHandler);
  }

  getEventTypes(): Observable<IType[]>{
    const url = "/assets/data/eventTypes.json"; 
    return this.http.get<IType[]>(url)
                    .catch(this.errorHandler);
  }

  getMentionTypes(): Observable<IType[]>{
    const url = "/assets/data/mentionTypes.json"; 
    return this.http.get<IType[]>(url)
                    .catch(this.errorHandler);
  }

  getTicketByUser(userId): Observable<ITickets[]>{
    const url = "/assets/data/userTickets.json"; 
    //url = url + userId
    return this.http.get<ITickets[]>(url)
                    .catch(this.errorHandler);
  }

  getAllTickets(): Observable<ITickets[]>{
    const url = "/assets/data/userTickets.json"; 
    //url = "http://localhost:8080/kursach_war_exploded/rest/admin/get/tickets"
    return this.http.get<ITickets[]>(url)
                    .catch(this.errorHandler);
  }
  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }

}
