import { Component, OnInit } from '@angular/core';
import { FacultyService } from '../../services/faculty.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FacaltyModel } from '../../model/faculty';
import { Router } from '@angular/router';


@Component({
  selector: 'app-save',
  templateUrl: './save.component.html',
  styleUrl: './save.component.css'
})
export class SaveComponent implements OnInit {

  faculty: FacaltyModel = new FacaltyModel();
  fromGroup!: FormGroup;
  facultiesData: any;



  constructor(
    private facultyService: FacultyService,
    private formbuilder: FormBuilder,
    private router:Router

  ) { }

  ngOnInit(): void {

    this.fromGroup = this.formbuilder.group({

      name: [''],
      totalSeat: ['']
    });
  }

  createFaulty(){
    this.faculty.name=this.fromGroup.value.name;
    this.faculty.totalSeat=this.fromGroup.value.totalSeat;
    this.facultyService.saveFaculty(this.faculty).subscribe({
      next:res=>{
        this.facultiesData=res;
        this.router.navigate(['/view']);
      },
      error:err=>{
        console.log("Faculty Not created",err);
      }
    });
    }

  }


