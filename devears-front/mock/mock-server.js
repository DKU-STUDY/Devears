const jsonServer = require('json-server');
const mockServer = jsonServer.create();
const { join } = require("path");
const router = jsonServer.router(join(__dirname, 'data.json'));
const middlewares = jsonServer.defaults();

mockServer.use(jsonServer.bodyParser);
mockServer.use(middlewares);
mockServer.use("/api", router);
mockServer.listen(8080, () => {
  console.log('JSON Server is running')
});
