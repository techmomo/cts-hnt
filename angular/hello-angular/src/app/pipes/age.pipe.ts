import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'age'
})
export class AgePipe implements PipeTransform {

  transform(dob: Date): number {
    // let month_diff = Date.now() - dob.getTime();
    // let age_diff = new Date(month_diff);
    // let year = age_diff.getUTCFullYear();
    // let age = Math.abs(year - dob.getUTCFullYear());
    const today = new Date();
    let age = today.getUTCFullYear() - dob.getUTCFullYear();
    return age;
  }
}
