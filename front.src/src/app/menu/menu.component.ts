import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  role: string;
  constructor( private cookie: CookieService) {}

  ngOnInit() {
    this.role = this.cookie.get('role');
  }

}
