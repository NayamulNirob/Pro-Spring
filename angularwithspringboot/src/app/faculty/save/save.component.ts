import { Component, OnInit } from '@angular/core';
import { FacultyService } from '../../services/faculty.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FacaltyModel } from '../../model/faculty';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-save',
  templateUrl: './save.component.html',
  styleUrl: './save.component.css'
})
export class SaveComponent implements OnInit {

  faculty: FacaltyModel = new FacaltyModel();
  formGroup!: FormGroup;
  facultiesData: any;



  constructor(
    private facultyService: FacultyService,
    private formbuilder: FormBuilder,
    private router: Router

  ) { }

  ngOnInit(): void {

    this.formGroup = this.formbuilder.group({

      name: [''],
      totalSeat: [0]
    });
  }

  createFaulty() {
    this.faculty.name = this.formGroup.value.name;
    this.faculty.totalSeat = this.formGroup.value.totalSeat;
    this.facultyService.saveFaculty(this.faculty).subscribe({
      next: res => {
        console.log(res);
        this.formGroup.reset();
        this.router.navigate(['/facview']);
      },
      error: err => {
        console.log(err);
      }
    });
  }

  // createFaculty() {
  //   this.faculty.name = this.formValue.value.name;
  //   this.faculty.totalSeat = this.formValue.value.totalSeat;  // Add this line

  //   this.facultyService.createFaculty(this.faculty)
  //     .subscribe({
  //       next: res => {
  //         console.log(res);
  //         this.formValue.reset();
  //         this.router.navigate(['/viewFaculty']);
  //       },
  //       error: error => {
  //         console.log(error);
  //       }
  //     });
  // }

  // faculty: FacaltyModel = new FacaltyModel();
  // formValue!: FormGroup;
  // facultyData: any;

  // constructor(
  //   private facultyService: FacultyService,
  //   private router: Router,
  //   private httpClient: HttpClient,
  //   private formBuilder: FormBuilder
  // ) {}

  // ngOnInit(): void {
  //   this.formValue = this.formBuilder.group({
  //     name: [''],
  //     totalSeat: [''],
  //   });
  // }

  // createFaculty() {
  //   this.faculty.name = this.formValue.value.name;
  //   this.faculty.totalSeat = this.formValue.value.totalSeat;  // Add this line

  //   this.facultyService.saveFaculty(this.faculty)
  //     .subscribe({
  //       next: res => {
  //         console.log(res);
  //         this.formValue.reset();
  //         this.router.navigate(['/facview']);
  //       },
  //       error: error => {
  //         console.log(error);
  //       }
  //     });
  // }



}


