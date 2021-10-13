import { AbstractControl, FormControl, ValidationErrors } from '@angular/forms';
import * as moment from 'moment';

 
export class DateValidator {
  static dateVaidator(AC) {
    var year = parseInt(moment(AC).format('YYYY'))
    if (year >1900 && year <2999) {
      return true;
    }
    return false
  }

}
