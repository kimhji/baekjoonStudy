const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let colors = new Set();

// 입력 받기
rl.on('line', (line) => {
    line.trim().split(' ').forEach(color => {
        colors.add(color);
    });
});

rl.on('close', () => {
    let colorsArray = Array.from(colors);
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

    // 출력
    map.forEach(pair => {
        console.log(pair[0] + ' ' + pair[1]);
    });
});
