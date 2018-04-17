import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router,  private cookie: CookieService) { }
/*this.cookie.get('role')=='NOT_USER'*/
/*localStorage.getItem('role')=='NOT_USER'*/

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      if(!this.cookie.check('role')) return true;
      else
      {
        this.router.navigate(['']);
        return false;
      }
    }
}
