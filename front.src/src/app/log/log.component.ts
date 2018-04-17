import { Component, OnInit } from '@angular/core';
import {IFullUser} from '../services/entites';
import {Router} from '@angular/router';
import { CookieService} from 'ngx-cookie-service';
import { ZooService} from '../services/services';

@Component({
  selector: 'app-log',
  templateUrl: './log.component.html',
  styleUrls: ['./log.component.css']
})
export class LogComponent implements OnInit {

  login: string;
  password: string;
  errorMsg: boolean = false;
  currUser: IFullUser;

  constructor(private router: Router, private cookie: CookieService, private service: ZooService) { }

  onSubmit()
  {
      this.cookie.set('role','ADMIN');
      this.cookie.set('user', JSON.stringify(this.currUser));
      location.reload();
  }

  ngOnInit() {
  }

}
