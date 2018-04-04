import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { News } from './news';

@Component({
  selector: 'app-admin-add-news',
  templateUrl: './admin-add-news.component.html',
  styleUrls: ['./admin-add-news.component.css']
})
export class AdminAddNewsComponent implements OnInit {

  private addForm;
  nNews = new News('','',null);

  constructor(private fb: FormBuilder) {
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
  }

  titleChange(title)
  {
    console.log("title");
    this.nNews.title = title;
  }

  contentChange(content)
  {
    console.log(content);
    this.nNews.content = content;
  }

  get currentNews() { return JSON.stringify(this.nNews); }
}
