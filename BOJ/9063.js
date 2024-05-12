let inputs = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n"); // /dev/stdin

let count = inputs[0];
let minX = 10000;
let minY = 10000;
let maxX = -10000;
let maxY = -10000;

for(let i = 1; i <= count; i++){
    let n = inputs[i].split(" ");
    minX = Math.min(minX, n[0]);
    minY = Math.min(minY, n[1]);
    maxX = Math.max(maxX, n[0]);
    maxY = Math.max(maxY, n[1]);
}
console.log((maxX - minX) * (maxY - minY))