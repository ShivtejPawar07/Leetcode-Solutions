class EventEmitter {
	constructor() {
		this.events = new Map();
	}

	/**
	 * @param {string} eventName
	 * @param {Function} callback
	 * @return {Object}
	 */
	subscribe(eventName, callback) {
		const callbacks = this.events.get(eventName) || [];
		// 添加回调函数
		callbacks.push(callback);
		this.events.set(eventName, callbacks);

		return {
			unsubscribe: () => {
				// 移除回调函数
				this.events.set(
					eventName,
					this.events.get(eventName).filter((i) => i !== callback)
				);
				return undefined;
			}
		};
	}

	/**
	 * @param {string} eventName
	 * @param {Array} args
	 * @return {Array}
	 */
	emit(eventName, args = []) {
		const callbacks = this.events.get(eventName) || [];
		// 调用每个回调函数，传递参数
		return callbacks.map((cb) => cb(...args));
	}
}