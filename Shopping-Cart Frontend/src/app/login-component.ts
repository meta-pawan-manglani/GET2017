import { User } from './user';
import { Component, OnInit } from '@angular/core';
import {LoginService} from './login-service.service';
import { Authentication } from './Authentication';
import { Router } from '@angular/router';

@Component({
    selector: 'my-login',
    templateUrl: './login.html',
    styleUrls: [ './login-style.css' ]
  })


  export class LoginComponent implements OnInit {
    authenticationObject:Authentication;
    constructor(private log:LoginService,private router:Router){}
    ngOnInit(): void {
       
      }
      login(username:string,password:string){
        this.log.getUser(username,password).then(response => {
          
          this.authenticationObject = response;
          if(this.authenticationObject.authenticationFlag) {
                this.log.saveUser(username);
              this.router.navigate(['/dashboard']);
            }else {
              this.router.navigate(['/']);
            }
          
        });
       
     
      
      }
    }