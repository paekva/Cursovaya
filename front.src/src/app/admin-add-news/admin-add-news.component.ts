import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { News } from '../services/entites'
import {ZooService} from '../services/services';

@Component({
  selector: 'app-admin-add-news',
  templateUrl: './admin-add-news.component.html',
  styleUrls: ['./admin-add-news.component.css']
})
export class AdminAddNewsComponent implements OnInit {

  private addForm;
  nNews = null;

  constructor(private fb: FormBuilder,private _zooService: ZooService) {
    this.addForm = this.fb.group({
      title: '',
      news: ''
    });
  }

  ngOnInit() {
  }

  onSubmit(event)
  {
    this.nNews.date = new Date();
    //отправить на сервер JSON.stringify(this.nNews)
   // this._zooService.postNews(this.nNews);
  }

  titleChange(title) { this.nNews.title = title; }
  contentChange(content) { this.nNews.content = content; }
}
