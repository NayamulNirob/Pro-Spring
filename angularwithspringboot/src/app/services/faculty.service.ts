import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FacaltyModel } from '../model/faculty';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  baseUrl:string="http://localhost:8089/api/faculty/";

   

  constructor(private http:HttpClient) { }

  loadAllfaculties():Observable<any>{
    return this.http.get<any>(this.baseUrl+"view");

  }

  saveFaculty(faculty:FacaltyModel):Observable<FacaltyModel>{
    return this.http.post<FacaltyModel>(this.baseUrl+"save",faculty);
  }
}
