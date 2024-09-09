import { FacaltyModel } from "./faculty";

export class DepartmentModel {

    id!: number;
    name!: string;
    faculty: FacaltyModel = new FacaltyModel();
}