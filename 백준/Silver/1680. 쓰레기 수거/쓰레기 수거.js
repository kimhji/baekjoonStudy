const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const T = parseInt(inp[0].trim());
let idx = 1;
for (let cycle = 0; cycle < T; cycle++) {
  const [size, num] = inp[idx++].trim().split(" ").map(Number);
  let trash = [];
  let leftTrash = 0;
  let result = 0;
  let curHave = 0;
  for (let checkTrash = 0; checkTrash < num; checkTrash++) {
    let trashOne = inp[idx++].trim().split(" ").map(Number);
    trash.push(trashOne);
    leftTrash += trashOne[1];
  }
  while (leftTrash > 0) {
    curHave = 0;
    for (let checkTrash = 0; checkTrash < num; checkTrash++) {
      curHave += trash[checkTrash][1];
      if (curHave > size) {
        result += trash[checkTrash][0] * 2;
        break;
      }
      leftTrash -= trash[checkTrash][1];
      trash[checkTrash][1] = 0;
      if (curHave === size) {
        result += trash[checkTrash][0] * 2;
        break;
      }
    }
    if (curHave < size) result += trash[num - 1][0] * 2;
  }
  console.log(result);
}
