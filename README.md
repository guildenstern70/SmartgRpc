# Smart gRPC Project

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![Actions CI](https://github.com/guildenstern70/SmartgRpc/actions/workflows/gradle.yml/badge.svg)

This project implements two simple services using gRPC protocol supported by Quarkus Framework.

### How to run gRpc Server

Run developer version with

    gradle quarkusDev

### HTML Documentation

gRPC services has been documented in HTML using https://github.com/pseudomuto/protoc-gen-doc

### First service

It returns the MD5 digest of a given string.

_Service proto:_

```
service Md5Grpc {
    rpc Md5Service (Md5Request) returns (Md5Reply) {}
}

message Md5Request {
    string stringToHash = 1;
}

message Md5Reply {
    string hashCode = 1;
}
```


### Second service

It calculates the hypotenuse of a right triangle given the legs.

_Service proto:_

```
service HypotenuseGrpc {
  rpc HypotenuseService (HypotenuseRequest) returns (HypotenuseReply) {}
}

message HypotenuseRequest {
  double leg1 = 1;
  double leg2 = 2;
}

message HypotenuseReply {
  double hypotenuse = 1;
}
```


### Sample Client

For a sample client implementation in Go, see:
https://github.com/guildenstern70/SmartgRpcClient

### Testing with grpcurl

You can download 'grpcurl' to make easy testing from https://github.com/fullstorydev/grpcurl
You may also want to download 'jq' to format the output https://stedolan.github.io/jq/

    grpcurl -plaintext 0.0.0.0:8080 list
    grpcurl -plaintext 0.0.0.0:8080 describe smartgrpcproto.Md5Grpc
    grpcurl -plaintext 0.0.0.0:8080 describe smartgrpcproto.HypotenuseGrpc
    grpcurl -plaintext -d '{"stringToHash": "Hello World!"}' 0.0.0.0:8080 smartgrpcproto.Md5Grpc/Md5Service
    grpcurl -plaintext -d '{"leg1": 3, "leg2": 4}' 0.0.0.0:8080 smartgrpcproto.HypotenuseGrpc/HypotenuseService

### Docker (JVM Image)

Build image with:

    gradle clean build
    docker build -f src/main/docker/Dockerfile.jvm -t littlelite/smartgrpc .

Run built image with:

    docker run -i --rm -p 8080:8080 littlelite/smartgrpc


### Docker (Native Image)

If you prefer the native docker image, be sure to build code using Graal JVM. To do so,
check the 'gradle.properties' file and adjust 'org.gradle.java.home' to a Graal JVM 17.

Then run:

    ./gradlew build -Dquarkus.package.type=native

If you build the native image on a Mac, you may want to use the following command:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

Then build the docker image with:

    docker build -f src/main/docker/Dockerfile.native -t littlelite/smartgrpc-native .

Run built image with:

    docker run -i --rm -p 8080:8080 littlelite/smartgrpc-native












