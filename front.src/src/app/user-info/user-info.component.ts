import { Component, OnInit } from '@angular/core';
import { IFullUser } from '../services/entites';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  account: IFullUser = null;
  private newP ='';
  private oldP ='';
  private name ='';
  private email = '';
  private info = '';
  show: boolean = true;
  succes: boolean = false;

  constructor() { }

  ngOnInit() {
    
  }

  oldPassword(password)  { this.oldP = password; }
  newPassword(password)  { this.newP = password; }
  newName(name) {this.name = name;}
  newEmail(name) {this.email = name;}
  newInfo(name) {this.info = name;}

  changeInfo()
  {
    if(this.info!='')this.account.info = this.info;
    if(this.name!='')this.account.name = this.name;
    if(this.email!='')this.account.email = this.email;
    this.info!='';
    this.name!='';
    this.email!='';
  }

  changePassword(){
    this.succes=false;
    if(this.oldP != this.account.password) 
    {
      this.show = false
      return;
    }
    else this.show = true;
    //А здесь отправка в бд
    this.account.password = this.newP;
    this.succes = true;
  }
}
