import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { RentialModel } from '../services/entites';
import { ZooService } from '../services/services'

@Component({
  selector: 'app-user-rential',
  templateUrl: './user-rential.component.html',
  styleUrls: ['./user-rential.component.css']
})
export class UserRentialComponent implements OnInit {

  private rentialForm;
  public errorMsg;
  public zoos = [];

  public animals=[];
  request: RentialModel;


  constructor(private fb: FormBuilder, private _zooService: ZooService) {
    this.rentialForm = this.fb.group({
      zoo: '',
      animal: '',
      dateTake: null,
      dateReturn: null,
      name: '',
      purpose: '',
      email: ''
    });
  }

  onZooChange(zoo) {
    this._zooService.getAnimalsByZoo(zoo)
      .subscribe(data => this.animals = data,
        error => this.errorMsg = error);
  }

  sendRequest()
  {
    this._zooService.postRential(this.request);
  }

  ngOnInit() {
    this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);
}

}
