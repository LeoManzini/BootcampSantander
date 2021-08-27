import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'replace'
})
export class ReplacePipe implements PipeTransform {

    transform(value: string, charToReplace: string, newCharValue: string) {
        return value.replace(charToReplace, newCharValue);
    }
}