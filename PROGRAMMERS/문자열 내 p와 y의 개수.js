function solution(s){
    let countP = 0;
    let countY = 0;
    
    for(const c of s) {
        if(c == 'p' || c == 'P') {
            countP++;
        }
        if(c == 'y' || c == 'Y') {
            countY++;
        }
    }

    return countP == countY;
}