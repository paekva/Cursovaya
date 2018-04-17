import {Component, OnInit} from '@angular/core';
import {UserLogin} from './user.login';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  account = new UserLogin('kate', 'back', 'Pavlova Kate', 'paekva@yandex.ru', '20 y.o from Spb with love');
  private newP = '';
  private oldP = '';
  private name = '';
  private email = '';
  private info = '';
  show = true;

  constructor() {
  }

  ngOnInit() {
  }

  oldPassword(password) {
    this.oldP = password;
  }

  newPassword(password) {
    this.newP = password;
  }

  newName(name) {
    this.name = name;
  }

  newEmail(name) {
    this.email = name;
  }

  newInfo(name) {
    this.info = name;
  }

  changeInfo() {
    if (this.info !== '') { this.account.info = this.info; }
    if (this.name !== '') { this.account.name = this.name; }
    if (this.email !== '') { this.account.email = this.email; }
    /*this.info != '';
    this.name != '';
    this.email != '';
    ошибки добавляют, ибо нет использования*/
  }

  changePassword() {
    if (this.oldP !== this.account.password) {
      this.show = false;
      return;
    } else {
      this.show = true;
    }
    /*А здесь отправка в бд*/
    this.account.password = this.newP;
  }

  get getName() {
    return JSON.stringify(this.account.name);
  }

  get getEmail() {
    return JSON.stringify(this.account.email);
  }

  get getInfo() {
    return JSON.stringify(this.account.info);
  }

  get getLogin() {
    return JSON.stringify(this.account.login);
  }
}
