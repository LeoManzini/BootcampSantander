import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
    templateUrl: './course-info.component.html'
})
export class InfoComponent implements OnInit {

    courseId!: number;

    constructor(private activatedRoute: ActivatedRoute) { }

    ngOnInit(): void {
        this.courseId = +this.activatedRoute.snapshot.paramMap.get('id')!
    }
}