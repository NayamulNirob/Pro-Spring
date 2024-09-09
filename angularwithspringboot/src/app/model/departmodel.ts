export class DepartmentModel {

    id!: number;
    name!: string;
    
    faculty!: {
        id: number;
        name: string;
        totalSeat: number;
    }
}