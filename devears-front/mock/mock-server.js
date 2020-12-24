const jsonServer = require('json-server');
const mockServer = jsonServer.create();
const { join } = require("path");
const router = jsonServer.router(join(__dirname, 'data.json'));
const middlewares = jsonServer.defaults();
const { normalize } = require('./utils');

mockServer.use(jsonServer.bodyParser);
mockServer.use(middlewares);

mockServer.get("/api/crew", (req, res) => {
  const { crew: { ids, entries }, users } = normalize(require("./data.json"));
  res.json(ids.map(id => ({
    ...entries[id],
    writer: users.entries[entries[id].writer]
  })));
});

mockServer.get("/api/crew/:idx", ({ params: {idx} }, res) => {
  const { crew: { entries }, users } = normalize(require("./data.json"));
  res.json({
    ...entries[idx],
    writer: users.entries[entries[idx].writer]
  });
});

mockServer.get("/api/users/:idx", ({ params: {idx} }, res) => {
  const { users: { entries } } = normalize(require("./data.json"));
  res.json(entries[idx]);
});

mockServer.use("/api", router);

mockServer.listen(8080, () => {
  console.log('JSON Server is running')
});
