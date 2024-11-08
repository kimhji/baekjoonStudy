const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const music = [];
for (let idx = 1; idx <= N; idx++) {
  music.push(parseInt(inp[idx].trim()));
}
const piano = ["A", "", "B", "C", "", "D", "", "E", "F", "", "G", ""];
const melodyValue = { A: 0, B: 2, C: 3, D: 5, E: 7, F: 8, G: 10 };
const startMelody = "A".charCodeAt(0);
for (let i = 0; i < 7; i++) {
  const startMelodyName = String.fromCharCode([startMelody + i]);
  let curValue = melodyValue[startMelodyName];
  let result = true;
  music.forEach((melody) => {
    curValue += melody + 24;
    curValue %= 12;
    if (!piano[curValue]) {
      result = false;
    }
  });
  if (result) {
    console.log(startMelodyName, piano[curValue]);
  }
}
