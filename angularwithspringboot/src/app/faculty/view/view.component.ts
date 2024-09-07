import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FacultyService } from '../../services/faculty.service';


@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrl: './view.component.css'
})
export class ViewComponent implements OnInit {
  faculty: any;

  constructor(
    private service: FacultyService,


  ) { }

  ngOnInit(): void {
    this.faculty = this.service.loadAllfaculties();
  }


}
