# MirageGDX
A Java port of the Mirage Source.

What is the Mirage Source you ask? Well, it is a now very dated and retro open source project for creating small 2d 
multiplayer online games written in Visual Basic 6. The original source code can be found [here](https://github.com/carlislefox/mirage-source-v3.0.3).

This project aims to bring the Mirage Source to the multi-platform world of Java, without drastic innovation or 
unnecessary changes. This means that by design this project is ignoring modern coding conventions in favour of porting 
the original codebase as directly as possible.

With that said, the tech stack here is obviously very different to VB6, so concessions have been made wherever 
absolutely necessary, mostly around the socket usage and LibGDX API.

# Why?
At the time of writing, the Mirage Source is all but lost to time. The project and its community are what got me into 
programming, and I think a straight port might at least open the door to fresh ideas and enthusiasm.

## Contact
At the moment this is just a bit of fun for me, so there is no way to directly get in contact.

## Tech

* Java
* LibGDX
* Gradle
* Android

## Module Structure
The project is broken up into several modules, each can be compiled separately, and there are interdependencies.

### Client
Houses all platform independent client code.

### Server
Houses all of the server side code.

### Shared
Code used by both the client and server.

### Desktop 
Platform specific launcher for desktop systems

### Android
Platform specific launcher for android systems