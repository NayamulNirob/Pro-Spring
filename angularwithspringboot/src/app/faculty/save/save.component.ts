import { Component, OnInit } from '@angular/core';
import { FacultyService } from '../../services/faculty.service';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-save',
  templateUrl: './save.component.html',
  styleUrl: './save.component.css'
})
export class SaveComponent implements OnInit{


constructor( 
  private facultyService:FacultyService,
  private formbuilder:FormBuilder


){}

  ngOnInit(): void {

  }

}
