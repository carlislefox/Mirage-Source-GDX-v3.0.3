# Mirage Source GDX v3.0.3
A Java port of the Mirage Source v3.0.3.

What is the Mirage Source you ask? Well, it is a now very dated and retro open source project for creating small 2d 
multiplayer online games written in Visual Basic 6. The original source code can be found [here](https://github.com/carlislefox/mirage-source-v3.0.3).

This project aims to bring the Mirage Source to the multi-platform world of Java, without drastic innovation or 
unnecessary changes. This means that by design this project is ignoring modern coding conventions in favour of porting 
the original v3.0.3 codebase as directly as possible, only making structural changes where it seems obviously obtuse 
_not to_.

With that said, the tech stack here is obviously very different to VB6, so concessions have been made wherever 
absolutely necessary, mostly around the socket usage and LibGDX API.

## Goals

1. Fully port the server, respect the protocol to the extent that the old vb6 client works with it
2. Fully port the client, in all its tiny fixed window size glory

## Why?
At the time of writing, the Mirage Source is all but lost to time. The project and its community are what got me into 
programming, and I feel an open source straight port to a modern language is a fitting karmic gift.

## Contact
At the moment this is just a bit of fun for me as I walk down memory lane, so there is no way to directly get in contact.

## Tech

* Java
* LibGDX
* Gradle

## Module Structure
The project is broken up into several modules, each can be compiled separately, and there are interdependencies.

### Client
Houses all of the client side code.

### Server
Houses all of the server side code.

### Shared
Code used by both the client and server.