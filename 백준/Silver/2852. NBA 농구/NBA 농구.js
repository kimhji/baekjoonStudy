const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
let score = 0;
let beforeTime = 0;
let resultTime = [0, 0];
//이기는 팀 1: 양수, 2: 음수
for (let idx = 1; idx <= N; idx++) {
  let [team, time] = inp[idx].trim().split(" ");
  let [minute, second] = time.split(":").map(Number);
  switch (team) {
    case "1":
      if (score === 0) {
        beforeTime = minute * 60 + second;
      }
      score++;
      if (score === 0) {
        resultTime[1] += minute * 60 + second - beforeTime;
      }
      break;
    case "2":
      if (score === 0) {
        beforeTime = minute * 60 + second;
      }
      score--;
      if (score === 0) {
        resultTime[0] += minute * 60 + second - beforeTime;
      }
      break;
  }
}
if (score > 0) {
  resultTime[0] += 48 * 60 - beforeTime;
} else if (score < 0) {
  resultTime[1] += 48 * 60 - beforeTime;
}

resultTime.forEach((time) => {
  console.log(
    Math.floor(time / 60)
      .toString()
      .padStart(2, "0") +
      ":" +
      (time % 60).toString().padStart(2, "0")
  );
});
