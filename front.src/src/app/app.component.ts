import {Component} from '@angular/core';
import { IFullUser} from './services/entites';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor( private cookie: CookieService)
  {
    let myObj = {
      login: '',
      password: '',
      name: '',
      email: '',
      info: ''
    };
    this.cookie.set('user',JSON.stringify(myObj));
  }
}
