import { Component, OnInit } from '@angular/core';
import { ZooService } from '../services/services';
import { IZoo } from '../services/entites';

@Component({
  selector: 'app-zoos',
  templateUrl: './zoos.component.html',
  styleUrls: ['./zoos.component.css']
})
export class ZoosComponent implements OnInit {

  errorMsg='';
  constructor(private _zooService: ZooService) { }
  zoos=[];
  zooId: IZoo = null;

  onClick(id)
  {
    this._zooService.getZooById(id)
      .subscribe(data => this.zooId = data,
                error => this.errorMsg = error);
  }

  ngOnInit() {
    this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);
}
}
