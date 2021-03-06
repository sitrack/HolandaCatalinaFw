![](https://img.shields.io/travis/javaito/HolandaCatalinaFw.svg)
![](https://img.shields.io/github/license/javaito/HolandaCatalinaFw.svg)
![](https://img.shields.io/github/release/javaito/HolandaCatalinaFw.svg)

# Holanda Catalina

## Motivation
Basing needs, to build a specific set of components by itself define a services-based architecture, we decided to provide high-level tools that build the structures necessary for the development of this type of platforms (PaaS)

In the following links a basic set of required components described for this type of platform:
- https://www.nginx.com/blog/introduction-to-microservices/?utm_source=service-discovery-in-a-microservices-architecture&utm_medium=blog
- http://microservices.io/index.html

Currently there are many implementations of general purpose Java development solutions, but none of these implementations is specifically created to develop a set of services interconnected with each other to form a platform.
As an example to create a service that responds to an HTTP REST interface based on java we have to think of a JEE solution, which includes an application server / web, not less libset and are generally systems that require powerful hardware. Unlike this example we propose simple code, without complex environments, without libraries that the solution does not require and are lightweight and flexible solutions without powerful hardware.

## Components
In this repository you will find a set of high-level solutions as a base for the development of each of the components needed to publish services, to consume third party services, to share resources between instances of the same service and to organize and discover services on the platform.

- Http Service Interface
- Service wrapper
- PaaS Protocol
- Shared Memory between instances (Cloud computing)
- Layered architecture
- Deployment service

### Http service interface
Among the high-level tools, the environment has a powerful high-performance HTTP server and very simple to use once. With this tool we can very simply public http interfaces without additional infrastructure or large hardaware requirements.

#### Publishing a local folder
Publishing some folder of your own computer...
```java
HttpServer server = new HttpServer(1338);
server.addContext(new FolderContext("", Paths.get("/home/javaito"));
server.start();
```
Then open your web browser on http://localhost:1338

Publishing some folder with default element...

First we create a file in the folder that we will publish called default.txt and put the next text into the file.
```txt
Hello world!!
```
then we need to publish a context with a default element
```java
HttpServer server = new HttpServer(1338);
server.addContext(new FolderContext("/home", Paths.get("/home/javaito", "default.txt"));
server.start();
```
open your browser again on http://localhost:1338/home

#### Publishing custom context
Publishing custom context whit low level implementation...
```java
byte[] document;
document = "Hello world!!".getBytes();
HttpServer server = new HttpServer(1338);
server.addContext(new Context(".*") {
    @Override
    public HttpResponse onContext(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.setResponseCode(HttpResponseCode.OK);
        response.setBody(document);
        response.addHeader(new HttpHeader(HttpHeader.CONTENT_LENGTH, Integer.toString(document.length)));
        response.addHeader(new HttpHeader(HttpHeader.CONTENT_TYPE, MimeType.TEXT_PLAIN.toString()));
        return response;
    }
});
server.start();
```

### Service wrapper
First we can consume some third party service and implements any wrapper solution
```java

```

### PaaS Protocol


### Shared memory between instances


### Layered architecture


### Deployment service
