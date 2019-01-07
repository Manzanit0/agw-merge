# HTTP Server

[![Build Status](https://travis-ci.org/Manzanit0/HttpServer.svg?branch=master)](https://travis-ci.org/Manzanit0/HttpServer)
[![codecov](https://codecov.io/gh/Manzanit0/HttpServer/branch/master/graph/badge.svg)](https://codecov.io/gh/Manzanit0/HttpServer)

A HTTP Server tool developed as a learning exercise.

Made in Java. In London.

## Getting started

To get the application ready:
```bash
git clone ...
mvn package
```

To execute the server:
```bash
java -jar http-server-1.0.jar server
```

To run the tests:
```bash
mvn test
```

To run the acceptance tests:
```bash
cd acceptance/
bundler install
bundler exec spinach
```

## Starting up the server

Here is the bootstrap code to start the server:

```java
import application.*;
import core.Connection;
import core.Router;
import core.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String... args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Connection conn = new Connection(serverSocket);
        Router router = new Router();
        Server server = new Server(conn, router);

        System.out.println("Listening for connection on port 5000 ....");
        server.start();
    }
}
```

Take into account that unless created, the router won't have any default endpoints created,
returning therefor always `NOT FOUND`.

## Creating a new endpoint

In order to create a new endpoint simply extend from the base class `Endpoint` and
implement all the HTTP methods you require, such as below:

```java
package application;

import core.Endpoint;
import core.models.Request;
import core.models.Response;

public class HelloWorld extends Endpoint {
    public String getUri() {
        return "/hello-world";
    }

    @Override
    public Response get(Request request) {
        return Response.ok();
    }
}

```

And then add the endpoint to the router, wherever you've defined it:

```java
Router router = new Router();
router.add(new HelloWorld());
```

