import { Injectable } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DateUtil } from '../utils/date.util';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users:UserDto[]

  constructor(private builder:FormBuilder) { 
    this.users = [
      {
        id: 1,
        name: 'User1',
        email: 'usr1@gmail.com',
        salary: 1000,
        dob: new Date("01/01/1990")
      },
      {
        id: 2,
        name: 'User2',
        email: 'usr2@gmail.com',
        salary: 1500,
        dob: new Date("12/12/1991")
      },
      {
        id: 3,
        name: 'User3',
        email: 'usr3@gmail.com',
        salary: 1500,
        dob: new Date("11/11/2000")
      },
      {
        id: 4,
        name: 'Use4',
        email: 'us4@gmail.com',
        salary: 920,
        dob: new Date("09/11/1987")
      }
    ];
  }

  buildUserForm():FormGroup{
    const date = new Date();
    const strDate = `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`;
    console.log(strDate);
    return this.builder.group({
      id: ['',Validators.required],
      name: ['',Validators.required],
      email: ['',[ Validators.required, Validators.email]],
      salary: ['',[Validators.min(600),Validators.max(5000)]],
      dob: DateUtil.getLocaleDateString(new Date('01/11/1990'))
    });
  }
  
  getUsers():UserDto[]{
    return this.users;
  }

  addUser(user:UserDto):void{
    this.users.push(user);
  }

  deleteUser(user:UserDto):void{
    this.users = this.users.filter(u=> u !== user);
  }
}
