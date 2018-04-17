import {Component, OnInit} from '@angular/core';
import {HttpService} from '../http.service';
import {New} from '../new';
import {ActivatedRoute} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';
import {News} from '../services/entites';

@Component({
  selector: 'app-new-conteiner',
  templateUrl: './new-conteiner.component.html',
  styleUrls: ['./new-conteiner.component.css'],
  providers: [HttpService]
})

export class NewConteinerComponent implements OnInit {

  news: News[] = [];
  private sub: any;
  ids: number;

  constructor(private httpService: HttpService, private route: ActivatedRoute, private cookie: CookieService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { this.ids = +params['id']; });
    this.news = JSON.parse(this.cookie.get('news'));
  }

}
