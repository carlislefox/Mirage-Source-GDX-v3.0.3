# MirageGDX
A Java port of the Mirage Source.

What is the Mirage Source you ask? Well, it is a now very dated and retro open source project for creating small 2d 
multiplayer online games written in Visual Basic 6. The original source code can be found [here](https://github.com/carlislefox/mirage-source-v3.0.3).

This project aims to bring the Mirage Source to the multi-platform world of Java, without drastic innovation or 
unnecessary changes. This means that by design some of the approaches, concepts and patterns found within may seem 
dated or quaint when viewed through the lens of modern development practises.

With that said, if you are looking for a compact and opinionated multi-platform canvas on which to paint your retro 
MMORPG masterpiece, this might be just what you are looking for.

## Contact
You can get in touch with the developers behind this project via [this Discord server](https://discord.gg/C5vFaAq2tP).

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