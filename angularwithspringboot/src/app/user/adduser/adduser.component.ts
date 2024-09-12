import { Component, OnInit } from '@angular/core';
import { UserModel } from '../../model/usermodel';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrl: './adduser.component.css'
})
export class AdduserComponent {

  selectedFile: File | null = null;
  user: UserModel = new UserModel();

  constructor(private userService: UserService,
    private router: Router
  ) { }
 

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  onSubmit() {
    if (this.selectedFile) {
      this.userService.addUser(this.user, this.selectedFile).subscribe({
        next: res => {
          console.log("User Added succesfully", res);
          this.router.navigate(['/userview']);

        },
        error: err => {
          console.error("User Not Added", err)
        }
      });
    }
    else {
      alert('Please Select an image');
    }
  }
}
