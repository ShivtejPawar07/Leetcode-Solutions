/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let farr=[];
    for(let i=0;i<arr.length;i++){
        if(fn(arr[i],i)){
            farr.push(arr[i]);
        }
    }
    return farr;
};