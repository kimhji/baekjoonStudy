const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let colorSet = new Set();
inp.forEach(line =>{
    let colors = line.trim().split(" ");
    colors.forEach(color =>{
        colorSet.add(color);
    })
})

let colorsArray = Array.from(colorSet);
let map = [];

// 모든 색깔 쌍 생성
for (let i = 0; i < colorsArray.length; i++) {
    for (let j = 0; j < colorsArray.length; j++) {
        map.push([colorsArray[i], colorsArray[j]]);
    }
}

// 정렬
map.sort((a, b) => {
    if (a[0] !== b[0]) {
        return a[0].localeCompare(b[0]);
    } else {
        return a[1].localeCompare(b[1]);
    }
});


let resultList = new Array(...map);

resultList.forEach(item=>{
    console.log(item[0]+" "+item[1]);
})