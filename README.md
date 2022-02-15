# Smart gRPC Project

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


This project implements two simple services using gRPC protocol.

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
