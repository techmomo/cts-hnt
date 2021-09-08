import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  messages:string[]
  status:boolean = false
  info:string
  num1:number
  num2:number
  constructor() { }

  ngOnInit() {
    this.messages = ["Hello","How", "Hola","Hey,you"];
  }

  clickMe(){
    alert('click me called');
    this.info = 'I was clicked';
    this.status = true;
  }
  clickNum1(e){
    console.log(e.target.value);
    //this.info = e.target.value;
    this.num1 = parseInt(e.target.value);
  }
  clickNum2(e){
    this.num2 = parseInt(e.target.value);
    this.info = `Sum is :  ${this.num1 + this.num2}`;
  }
}
