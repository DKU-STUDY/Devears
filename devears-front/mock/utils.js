const normalize = (data) => {
  return Object.entries(data).reduce((obj, [ key, value ]) => {
    obj[key] = {
      entries: value.reduce((children, v) => {
        children[v.idx] = v;
        return children;
      }, {}),
      ids: value.map(v => v.idx),
    }
    return obj;
  }, {});
}

module.exports = {
  normalize
};
