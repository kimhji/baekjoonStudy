function solution(S, idx, N, count) {
  if (N === count) {
    let str = [];
    S.forEach((value, key) => {
      if (value[0]) {
        str.push(key);
      }
    });
    console.log(str.join(" "));
    return;
  }
  let bag = [];
  S.forEach((value, key) => {
    if (!value[0] && value[1] > idx) {
      bag.push(key);
    }
  });
  bag.forEach((item) => {
    const curIdx = S.get(item)[1];
    S.set(item, [true, curIdx]);
    solution(S, curIdx, N, count + 1);
    S.set(item, [false, curIdx]);
  });
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let idx = 0;
let [k, ...S] = inp[idx++].trim().split(" ").map(Number);
let SMap = new Map();
while (k !== 0) {
  S.forEach((item, idx) => {
    SMap.set(item, [false, idx]);
  });
  solution(SMap, -1, 6, 0);

  [k, ...S] = inp[idx++].trim().split(" ").map(Number);
  SMap = new Map();
  console.log("");
}
