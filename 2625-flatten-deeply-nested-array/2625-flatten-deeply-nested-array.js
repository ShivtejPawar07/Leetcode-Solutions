/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    let result = [];

    function helper(current, depth) {
        for (let item of current) {
            if (Array.isArray(item) && depth > 0) {
                helper(item, depth - 1); // flatten deeper
            } else {
                result.push(item); // push element or unflattened array
            }
        }
    }

    helper(arr, n);
    return result;
};