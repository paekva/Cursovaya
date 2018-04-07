import {Component, OnInit} from '@angular/core';
import {HttpService} from '../services/news.service';
import {News} from '../services/entites'

@Component({
  templateUrl: './news.component.html',
  selector: 'app-news',
  styleUrls: ['./news.component.css'],
  providers: [HttpService]
})

export class NewsComponent implements OnInit {

  news: News[] = [];

  constructor(private httpService: HttpService) {
  }

  ngOnInit() {
    this.httpService.getData().subscribe(data => this.news = data['newList']);
  }

}
