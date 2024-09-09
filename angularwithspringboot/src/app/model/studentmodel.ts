import { DepartmentModel } from "./departmodel";
import { FacaltyModel } from "./faculty";

export class StudentModel{

    id!:number;
    name!:string;
    age!:number;
    gender!:string;
    birthday!:Date;

    department:DepartmentModel=new DepartmentModel();
    faculty:FacaltyModel =new FacaltyModel();
    
}