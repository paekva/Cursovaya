import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Injectable()
export class UserGuard implements CanActivate {

    constructor(private router: Router, private _cookieService:CookieService) { }
/*this._cookieService.get('role')=='USER'*/
/*localStorage.getItem('role')=='USER'*/

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if ((this._cookieService.check('role'))&&(this._cookieService.get('role')=='USER')) {
            // logged in so return true
            return true;
        }
        this.router.navigate(['login']);
        return false;
    }
}
