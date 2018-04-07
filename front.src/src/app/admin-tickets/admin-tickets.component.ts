import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { ZooService } from '../services/services';
import { SearchRequest } from '../search/search.model';

@Component({
  selector: 'app-admin-tickets',
  templateUrl: './admin-tickets.component.html',
  styleUrls: ['./admin-tickets.component.css']
})
export class AdminTicketsComponent implements OnInit {

  public result = [];

  model = new SearchRequest(' ', '', '');
  public zoos=[];
  public errorMsg;
  public types = [
    { value: '1', display: 'Книга' },
    { value: '2', display: 'Статья' },
    { value: '3', display: 'Интернет-блог' }
  ];

  private searchForm;

  constructor(private fb: FormBuilder,private _zooService: ZooService) {
    this.searchForm = this.fb.group({
      type: '',
      zoo: '',
      date: 0
    });
  }

  onTypeChange(type) { this.model.type = type;}

  onZooChange(zoo) { this.model.zoo = zoo; }

  ngOnInit() {
    /*this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);*/
    this._zooService.getAllTickets()
      .subscribe(data => this.result = data,
                error => this.errorMsg = error);
}

}
