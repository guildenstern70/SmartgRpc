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
