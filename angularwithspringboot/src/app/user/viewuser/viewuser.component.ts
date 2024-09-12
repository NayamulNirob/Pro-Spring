import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-viewuser',
  templateUrl: './viewuser.component.html',
  styleUrl: './viewuser.component.css'
})
export class ViewuserComponent implements OnInit{

  users:any;

  constructor(private userService:UserService){}


  ngOnInit(): void {
    this.loadAlluser();
  }

  loadAlluser(){
    this.userService.getAllUser().subscribe({
      next:res=>{
       this.users=res
      },
      error:err=>{
        console.error("User error",err)
      }
    });
  }

}
