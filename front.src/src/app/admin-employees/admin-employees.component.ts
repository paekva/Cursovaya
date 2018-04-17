import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ZooService } from '../services/services';

@Component({
  selector: 'app-admin-employees',
  templateUrl: './admin-employees.component.html',
  styleUrls: ['./admin-employees.component.css']
})
export class AdminEmployeesComponent implements OnInit {

  public zoos=[];
  public employee;
  choosedZoo: string = "";
  name: string ="";

  public errorMsg;
  public results = "вами не был запущен никакой процесс поиска";
  private searchForm;

  constructor(private fb: FormBuilder, private _zooService: ZooService) {
    this.searchForm = this.fb.group({
      title: '',
      news: ''
    });
  }

  ngOnInit() {
    this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);
              }

  onZooChange(zoo) { this.choosedZoo = zoo; }

  /*
  onZooSubmit(){
    //search for emloyess, who work in zoo with id this.choosedZoo
    this._employeeService.getEmployeesByZoo(this.choosedZoo)
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);
  }*/
  onNameSubmit() {
    //search for employee, called this.name
    this._zooService.getEmployeeByName(this.name)
      .subscribe(data => this.employee = data,
                error => this.errorMsg = error);
  }
}
