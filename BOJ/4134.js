let inputs = require('fs').readFileSync('BOJ/nodejs.txt').toString().trim().split("\n"); //BOJ/nodejs.txt 


for(let i = 1, end = inputs[0]; i <= end; i++){
    find(Number(inputs[i]));
}

function check(now){
    for(let i = 2; i <= Math.sqrt(now); i++){
        if(now % i == 0) return false
    }
    return true
}

function find(now){
    let next = now
    while(true){
        if(next == 0 || next == 1) {
            console.log(2)
            return
        } 
        if(check(next)){
            console.log(next)
            return
        }
        next = next + 1
    }
}

