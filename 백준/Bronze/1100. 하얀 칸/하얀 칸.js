const fs = require('fs');
//let input = fs.readFileSync('./input.txt').toString().split('\n');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let result = 0;
for(let i = 0;i<8;i++){
    word = input[i].split('')
    for(let j = 0; j<8;j++){
        if ((i+j)%2 == 0){
            if(word[j] == 'F')
            result += 1;
        }
    }
}
console.log(result);