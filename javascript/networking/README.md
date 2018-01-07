# Chapter 3: Networking with Sockets

## Net-watcher.js
The novel parts to the net-watcher program begin inside the callback function given to createServer(). This callback function does three things:
- It reports that the connection has been established (both to the client with connection.write and to the console).
- It begins listening for changes to the target file, saving the returned watcher object. This callback sends change information to the client using connection.write.
- It listens for the connection’s close event so it can report that the subscriber has disconnected and stop watching the file, with watcher.close().

Finally, notice the callback passed into server.listen() at the end. Node invokes this function after it has successfully bound port 5432 and is ready to start receiving connections.

Wilson, Jim R. (2013-11-25). Node.js the Right Way: Practical, Server-Side JavaScript That Scales (Kindle Locations 683-690). Pragmatic Bookshelf. Kindle Edition.

To run and test the net-watcher program:

    $ node --harmony net-watcher.js target.txt

To connect to the TCP Socket Server via Telnet:

    $ telnet localhost 5432

Then, open a terminal to modify the watched file and view the log.
