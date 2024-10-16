const fs = require("fs");
const inp = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let firstLine = inp[0].trim().split(" ");
let idx = 1;
let year = 1;
while (firstLine[0] !== "0") {
  console.log("year", year++);
  let N = parseInt(firstLine[0]);
  let sortList = firstLine[1].split("");
  let wordList = [];
  for (let count = 0; count < N; count++) {
    let word = inp[idx++].trim().split("");
    wordList.push(word);
  }
  wordList.sort((a, b) => {
    if (a.length < b.length) {
      for (let comp = 0; comp < a.length; comp++) {
        let aV = sortList.indexOf(a[comp]);
        let bV = sortList.indexOf(b[comp]);
        if (aV !== bV) return aV - bV;
      }
      return -1;
    } else {
      for (let comp = 0; comp < b.length; comp++) {
        let aV = sortList.indexOf(a[comp]);
        let bV = sortList.indexOf(b[comp]);
        if (aV !== bV) return aV - bV;
      }
      return 1;
    }
  });
  wordList.forEach((one) => {
    console.log(one.join(""));
  });
  firstLine = inp[idx++].trim().split(" ");
}
