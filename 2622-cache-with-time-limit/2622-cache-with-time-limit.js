class TimeLimitedCache {
    constructor() {
        this.cache = new Map();
    }

    set(key, value, duration) {
        const currentTime = Date.now();
        const expiryTime = currentTime + duration;

        let exists = false;

        if (this.cache.has(key)) {
            const data = this.cache.get(key);
            if (data.expiry > currentTime) {
                exists = true;
            }
        }

        this.cache.set(key, { value: value, expiry: expiryTime });

        return exists;
    }

    get(key) {
        const currentTime = Date.now();

        if (this.cache.has(key)) {
            const data = this.cache.get(key);

            if (data.expiry > currentTime) {
                return data.value;
            } else {
                this.cache.delete(key);
            }
        }

        return -1;
    }

    count() {
        const currentTime = Date.now();
        let total = 0;

        for (let [key, data] of this.cache) {
            if (data.expiry > currentTime) {
                total++;
            } else {
                this.cache.delete(key);
            }
        }

        return total;
    }
}