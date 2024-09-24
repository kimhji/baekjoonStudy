const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
const x = parseInt(input[0]); // 온기
const y = parseInt(input[1]); // 수분
const result = Math.floor(x + y + (Math.min(x, y) / 10));

console.log(result);
