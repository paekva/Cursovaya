import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import {News, IZoo, IZoos, IAnimal, IType, ITickets, IFullUser, IEmployee, Resp, RentialModel} from './entites';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {CookieService} from 'ngx-cookie-service';


@Injectable()
export class ZooService {

  constructor(private http:HttpClient, private cookie:CookieService) { }

  // POST REQUESTS

  postRential(apply: RentialModel)
  {
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/user/rential";
    return this.http.post(url, apply);
  }

  postChangedZoo(zoo: IZoo){
    const body =
    {
      name: zoo.name,
      manager: zoo.manager,
      functionality: zoo.func
    }
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/admin/change/zoo";
    return this.http.post(url, body);
  }

  localUser: IFullUser;

  login(login: string,pswd: string): Observable<any>
  {
      const url = "http://localhost:8080/kursovaya_war_exploded/rest/auth/single";
      const headers = new Headers();
      this.localUser.login = login;
      this.localUser.password = pswd;

      headers.append('Content-Type', 'application/json');
      return  this.http.post(url, JSON.stringify(this.localUser), {headers})      //added return
            .map(res => res.json());

   }

/*addComment (body: Object): Observable<News[]> {
        let bodyString = JSON.stringify(body); // Stringify payload
        let headers      = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options       = new RequestOptions({ headers: headers }); // Create a request option

        let url = "http://localhost:8080/kursovaya_war_exploded/rest/admin/add/news";
        return this.http.post(url, body, options) // ...using post request
                         .map((res:Response) => res.json()) // ...and calling .json() on the response to return data
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
    } */



  // GET REQUESTS

  getUserInfo(id): Observable<IFullUser>{
    const url="http://localhost:8080/kursovaya_war_exploded/rest/user/info"+id;
    return this.http.get<IFullUser>(url)
                    .catch(this.errorHandler);
  }

  getZoos(): Observable<IZoos[]>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/zoo/all";
    return this.http.get<IZoos[]>(url)
                    .catch(this.errorHandler);
  }

  getZooById(zooId): Observable<IZoo>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/zoo/single/" + zooId.toString();
    return this.http.get<IZoo>(url)
                    .catch(this.errorHandler);
  }

  getEmployeeByName(name):Observable<IEmployee>
  {
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/admin/get/employees/" + name;
    return this.http.get<IEmployee>(url)
                    .catch(this.errorHandler);
  }

  getAnimalsByZoo(zoo): Observable<IAnimal[]>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/search/animals/byZoo/"+zoo;
    return this.http.get<IAnimal[]>(url)
                    .catch(this.errorHandler);
  }

  getEmployeesByZoo(zoo): Observable<IEmployee[]>{
    //this._urlByZoo + zoo;
    const url = "/assets/data/employees.json";
    return this.http.get<IEmployee[]>(url)
                    .catch(this.errorHandler);
  }

  getAnimalTypes(): Observable<IType[]>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/service/animalTypes";
    return this.http.get<IType[]>(url)
                    .catch(this.errorHandler);
  }

  getEventTypes(): Observable<IType[]>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/service/eventTypes";
    return this.http.get<IType[]>(url)
                    .catch(this.errorHandler);
  }

  getMentionTypes(): Observable<IType[]>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/service/mentionTypes";
    return this.http.get<IType[]>(url)
                    .catch(this.errorHandler);
  }

  getAllTickets(): Observable<ITickets[]>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/admin/get/tickets";
    return this.http.get<ITickets[]>(url)
                    .catch(this.errorHandler);
  }

  getAllNews(): Observable<News[]>{
    const url = "http://localhost:8080/kursovaya_war_exploded/rest/news/all";
    return this.http.get<News[]>(url)
                    .catch(this.errorHandler);
  }
  getTicketByUser(userId): Observable<ITickets[]>{
    const url = "/assets/data/userTickets.json";
    //url = url + userId
    return this.http.get<ITickets[]>(url)
                    .catch(this.errorHandler);
  }

  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }

}
