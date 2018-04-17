import {Component, OnInit} from '@angular/core';
import {News} from '../services/entites'
import {ZooService} from '../services/services';
import {CookieService} from 'ngx-cookie-service';

@Component({
  templateUrl: './news.component.html',
  selector: 'app-news',
  styleUrls: ['./news.component.css']
})

export class NewsComponent implements OnInit {

  news: News[];
  num: number;
  errorMsg: string;
  constructor(private httpService: ZooService, private cookies: CookieService) {
  }

  ngOnInit() {
    this.httpService.getAllNews()
      .subscribe(data => { this.news = data; this.cookies.set('news',JSON.stringify(data))},
                error => this.errorMsg = error);
  }
}
