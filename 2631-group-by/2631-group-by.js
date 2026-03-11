/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const result = {};
    for (let i = 0; i < this.length; i++) {
        const key = fn(this[i]); // Call the callback to get the key
        if (!result[key]) {
            result[key] = []; // Initialize array if key doesn't exist
        }
        result[key].push(this[i]); // Add current item to the correct group
    }
    return result;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */