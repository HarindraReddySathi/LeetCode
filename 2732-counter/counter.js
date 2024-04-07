/**
 * @param {number} n
 * @return {Function} counter
 */

var createCounter = function(n) {
    let cur = n;
    return function() {
        cur=cur+1;
        return cur-1;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */