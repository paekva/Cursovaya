import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { RentialModel } from './rential.model';
import { ZooService } from '../services/services';
import { AnimalService } from '../services/animal.service';

@Component({
  selector: 'app-user-rential',
  templateUrl: './user-rential.component.html',
  styleUrls: ['./user-rential.component.css']
})
export class UserRentialComponent implements OnInit {

  private rentialForm;
  public errorMsg;
  public zoos = [];

  public animals;
  request = new RentialModel('','','','','',null,null);
  

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

  onZooChange(zoo)
  {
    this._zooService.getAnimalsByZoo(zoo)
      .subscribe(data => this.animals = data,
                  error => this.errorMsg = error);
    this.request.zoo = zoo;    
  }

  onAnimalChange(animal) { this.request.animal = animal; }

  sendRequest()
  {
    //send
  }

  ngOnInit() {
    this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);
}

}
