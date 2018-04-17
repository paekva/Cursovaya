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

  public errorMsg;

  constructor(private _zooService: ZooService) {
  }

  ngOnInit() {
    this._zooService.getAllTickets()
      .subscribe(data => this.result = data,
                error => this.errorMsg = error);
}

}
