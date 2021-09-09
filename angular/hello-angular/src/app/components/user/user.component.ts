import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users:UserDto[]
  userForm:FormGroup
  errorMessage:string
  // constructor injection for services
  constructor(private service:UserService) { }

  ngOnInit() {
    this.getUsers();
    this.userForm = this.buildForm();
  }

  buildForm():FormGroup{
    return this.service.buildUserForm();
  }
  getUsers(){
    this.users = this.service.getUsers();
  }

  addUser(user:UserDto){
    this.service.addUser(user);
    this.getUsers();
  }

  deleleUser(user:UserDto){
    this.service.deleteUser(user);
    this.getUsers();
  }

  // events
  saveUser(){
    console.log(this.userForm);
    if(this.userForm.status !== 'INVALID'){
      this.errorMessage = undefined;
      this.addUser({
        id: this.userForm.value.id,
        name: this.userForm.value.name,
        email: this.userForm.value.email,
        salary: this.userForm.value.salary,
        dob: new Date(this.userForm.value.dob)
      });
    }else{
      this.errorMessage = 'Please verify your errors';
    }
  }
}
