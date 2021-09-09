
export class DateUtil{
    static getLocaleDateString(date:Date):string{
        // this will return date in YYYY-mm-dd
        // let minsOffSet = date.getTimezoneOffset();
        // let millsOffSet = minsOffSet * 60 * 1000;
        // const local = new Date(date.getMilliseconds() + millsOffSet);
        let day = ('0'+date.getDate()).slice(-2);
        let month = ('0'+ (date.getMonth() + 1)).slice(-2);
        let year = date.getFullYear();
        const newDate = year + '-' + month + '-' + day;
       return newDate;
    }
}