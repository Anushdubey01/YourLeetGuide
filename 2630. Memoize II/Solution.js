const RES = Symbol("res");

/**
 * @param {Function} fn
 */
function memoize(fn) {
  const globalCache = new Map();

  return (...params) => {
    let currentCache = globalCache;
    for (const param of params) {
      if (!currentCache.has(param)) {
        currentCache.set(param, new Map());
      }
      currentCache = currentCache.get(param);
    }

    if (currentCache.has(RES)) return currentCache.get(RES);

    const result = fn(...params);

    currentCache.set(RES, result);
    return result;
  };
}

const getInputs = () => [[{},{}],[{},{}],[{},{}]];
const myFn = memoize(function (a, b) { return ({...a, ...b}); });

const inputs = getInputs();
const output = [];
for (const arr of inputs) {
  const calls = arr.reduce((acc, cur) => acc + (typeof cur === 'object' ? 1 : 0), 0);
  output.push({ val: myFn(...arr), calls });
}

console.log(output);
