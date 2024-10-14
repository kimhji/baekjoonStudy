let curDate = new Intl.DateTimeFormat("ko-KR", {
  timeZone: "Asia/Seoul",
  year: "numeric",
  month: "numeric",
  day: "numeric",
  hour: "numeric",
  minute: "numeric",
  second: "numeric",
}).format(new Date());
let d = curDate.split(". ");
console.log(d[0] + "-" + (d[1] < 10 ? "0" + d[1] : d[1]) + "-" + d[2]);
//console.log(year + "-" + (month < 10 ? "0" + month : month) + "-" + day);
