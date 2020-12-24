const jsonServer = require('json-server');
const mockServer = jsonServer.create();
const { join } = require("path");
const router = jsonServer.router(join(__dirname, 'data.json'));
const middlewares = jsonServer.defaults();
const { normalize } = require('./utils');

mockServer.use(jsonServer.bodyParser);
mockServer.use(middlewares);

mockServer.get("/api/crew", (req, res) => {
  const data = normalize(require("./data.json"));
  console.log(data);
  const { crew: { ids, entries }, users } = data;
  res.json(ids.map(id => ({
    ...entries[id],
    writer: users.entries[entries[id].writer]
  })));
});

mockServer.use("/api", router);

mockServer.listen(8080, () => {
  console.log('JSON Server is running')
});
