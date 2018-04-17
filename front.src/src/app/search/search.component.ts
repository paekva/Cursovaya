import { Component, OnInit } from '@angular/core';
import { SearchRequest } from './search.model';
import { FormBuilder } from '@angular/forms';
import { ZooService } from '../services/services';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit {

  public results = [];

  public mode = 0;
  public zoos=[];
  public errorMsg;
  public subjects = [
    { value: '1', display: 'Животные' },
    { value: '2', display: 'Мероприятия' },
    { value: '3', display: 'Упоминания о зоопарке' }
  ];
  public types;

  private searchForm;

  constructor(private fb: FormBuilder,private _zooService: ZooService) {
    this.searchForm = this.fb.group({
      subject: '',
      type: '',
      zoo: '',
      before: false,
      date: 0,
      data: []
    });
  }


  model = new SearchRequest(' ', '', '');

  onSubjectChange(subject)
  {
   if (subject==1) {
    this.mode= 1;
    this._zooService.getAnimalTypes()
      .subscribe(data => this.types = data,
                error => this.errorMsg = error);
   }
   else if(subject==2){
    this.mode= 2;
    this._zooService.getEventTypes()
      .subscribe(data => this.types = data,
                error => this.errorMsg = error);
   }
   else{
    this.mode= 3;
    this._zooService.getMentionTypes()
      .subscribe(data => this.types = data,
                error => this.errorMsg = error);
   }
    this.model.subject = subject;
  }


  onTypeChange(type) { this.model.type = type;}
  onZooChange(zoo) { this.model.zoo = zoo; }

  onSubmit()
  {
    //Тут зделать пост запрос
    // if mode ==1 и тд
    this._zooService.getEventTypes()
      .subscribe(data => this.results = data,
                error => this.errorMsg = error);
  }

  ngOnInit() {
    this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);
}

  get currentSearchRequest() { return JSON.stringify(this.model); }

}
