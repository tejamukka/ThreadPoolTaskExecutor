# ThreadPoolTaskExecutor

TaskExecutor is a service class that maintains a pool (collection) of N threads that are used to execute instances of Tasks provided by the TaskExecutor’s clients. Interfaces for both the TaskExecutor and Task have been provided and must be used to implement the service (including the package structure). 

Project Goal
The primary goal of this project is to have team implement the multithreaded synchronization needed to implement the TaskExecutor. The secondary goal of the project (but perhaps the most difficult) is to implement the code boundedBuffer described in the text and given below using only Java’s Object as monitors and without the use of synchronized methods Note Synchronized blocks are acceptable, even needed.. 
