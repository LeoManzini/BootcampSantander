import { Component, OnInit } from "@angular/core";
import { Course } from "./course";

@Component({
    selector: 'app-course-list',
    templateUrl: './course-list.components.html'
})

export class CourseListComponents implements OnInit {

    courses: Course[] = [];

    ngOnInit(): void {
        this.courses = [
            {
                id: 1,
                name: 'Angular: Forms',
                imageUrl: '',
                price: 99.99,
                code: 'XPS-8796',
                duration: 120,
                rating: 4.8,
                releaseDate: 'September, 26, 2020'
            }, 
            {
                id: 1,
                name: 'Java 11',
                imageUrl: '',
                price: 199.99,
                code: 'XPS-8797',
                duration: 200,
                rating: 5.0,
                releaseDate: 'December, 21, 2021'
            }
        ]
    }
}