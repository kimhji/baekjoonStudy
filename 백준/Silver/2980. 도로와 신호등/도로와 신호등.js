const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let [N, L] = inp[0].trim().split(" ").map(Number);
let loc = 0;
let time = 0;
let light = [];
for(let i = 1;i<=N;i++){
    light.push(inp[i].trim().split(" ").map(Number));
}
while(loc < L){
    if(N>0){
        if(loc == light[0][0]){
            let curLight = light.shift();
            let tnsTime = time%(curLight[1]+curLight[2]);
            if(tnsTime<curLight[1]){
                time += curLight[1]-tnsTime;
            }
            N--;
        }
    }
    loc++;
    time++;
}
console.log(time);