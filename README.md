# Java Objects to and from a file.

This is a gradle-based Java project consisting of the first example provided in this [post](http://blog.acari.io/2017/05/07/Objects-from-file.html).
Which demonstrates the how object serialization to a file happens and why this is helpful in the first place.

When the project will run it will log some messages about how many objects where written to and from a file created it the 
directory the program was run in.

To run the sample you will need:
 - Internet Connection (At least the first time it is run)
 - [Java 8 runtime](http://blog.acari.io/jvm/2017/05/05/Gradle-Install.html)
 - [Gradle 2.3+ ](http://blog.acari.io/jvm/2017/05/05/Gradle-Install.html)
 
Once the repository is on your machine, in order to run the application.

1. Open up a command window and make the current working directory the root of the hazelcast-serialization repository
1. Run the command

        gradle run
        
The application will output a few logs, which could look like this:

    :compileJava UP-TO-DATE
    :processResources UP-TO-DATE
    :classes UP-TO-DATE
    :run
    [INFO]|2017-05-09 17:20:28,260:[Main.java]: 400 Programmer read from /home/alex/Workspace/object-to-file/Programmer.data!
    
    [INFO]|2017-05-09 17:20:28,282:[Main.java]: 400 ExternalizableProgrammer read from /home/alex/Workspace/object-to-file/ExternalizableProgrammer.data!
    
    
    BUILD SUCCESSFUL
    
    Total time: 0.902 secs

It can be seen that 400 objects were written to and read from two files, whose absolute paths are printed out.

Enjoy!

## -Alex
