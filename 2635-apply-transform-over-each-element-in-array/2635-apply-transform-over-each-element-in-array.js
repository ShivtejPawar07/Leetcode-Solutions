/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let rarr=[];
    for(let i=0;i<arr.length;i++){
       rarr[i]=fn(arr[i],i);
    }
    return rarr;
};