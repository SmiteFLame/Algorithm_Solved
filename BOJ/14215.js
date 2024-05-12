let inputs = require('fs').readFileSync('BOJ/nodejs.txt').toString().trim().split("\n"); //BOJ/nodejs.txt 


let input = inputs[0].split(' ').map(Number).sort((a, b) => a - b);

if(input[0] + input[1] > input[2]) {
    console.log(input[0] + input[1] + input[2])
} else{
    console.log((input[0] + input[1])* 2 - 1);
}

