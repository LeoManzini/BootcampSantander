import { Component, Input, OnChanges, OnInit, SimpleChanges } from "@angular/core";

@Component({
    selector: 'app-star-component',
    templateUrl: './star.components.html'
})

export class StarComponent implements OnChanges {

    @Input()
    rating: number = 0;
    
    starWidth: number = 0;

    ngOnChanges(): void {
        this.starWidth = this.rating / 94 * 5;
    }
}