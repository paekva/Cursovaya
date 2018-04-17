import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  role: boolean;
  constructor(private cookie: CookieService) { }

  ngOnInit() {
    this.role = this.cookie.check('role');
    //this.role =localStorage.getItem('role');
  }

}
