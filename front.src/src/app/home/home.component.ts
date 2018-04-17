import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {IFullUser} from '../services/entites';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor( private cookie: CookieService) { }
  usr: IFullUser;
  role:string;
  ngOnInit() {
    if(this.cookie.check('role')) this.role = this.cookie.get('role');
    this.usr = localStorage.get('user');
    //this.role = localStorage.getItem('role')
  }

}
