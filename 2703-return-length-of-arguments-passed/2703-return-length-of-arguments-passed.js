/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    /*let cnt=0;
    for(let val of args){
        cnt++;
    }
    return cnt;*/
    return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */