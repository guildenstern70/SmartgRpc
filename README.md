# Smart gRPC Project

This project implements two simple services using gRPC protocol.

### First service

It returns the MD5 digest of a given string.

Service proto:

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
