import { Injectable } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

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
    return this.builder.group({
      id: '',
      name: '',
      email: '',
      salary: '',
      dob: ''
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
