# Utilities

I keep some utilities here for repetitive code. These utilities are not safe, they bypass exception handling, and you generally shouldn't use them. I get bored of copypasta code in prototyping though, so these fix boring things.

## CompilerDirectives

This class is for selectively removing parts of your code when compiling. Works the same as IFDEF in actually well-designed languages.

How it works: The Java compiler (theoretically) removes obvious dead code when compiling. What "obvious" means is potentially debatable, but I have found that boolean constants inside conditionals is a sure bet. CompilerDirectives is a central location to declare these constants. Then, in your code, if you place entire blocks inside of a conditional over one of these constants, when your constant is false the compiler will remove it. I primarily use it for debug code. Example:

```
if(CompilerDirectives.DEBUG)
{
  System.out.println("Debug text");
}
```

You have to change the constants every time you compile, which sucks, and there are more advanced tools to do this. Generally speaking though, I prefer to keep my code with as few dependencies as possible, so this works.

## EasyIO

Does file handling. If you want to read a text file, just `EasyIO.readFile(path);`. To print text into a file, `EasyIO.printFile(path, content);`. **If you give it invalid arguments, it'll explode your computer.**

## EasyLogger

Utility for logging. The default Java logger takes way too much effort to initialize. EasyLogger does it for you. Just `EasyLogger.initializeLogger(logFilePath);` and then `EasyLogger.log(level, message);`. Currently it requires you to include the log level in `log()`, which is a pain and I haven't figured out how to skip that yet, but if you just want to quickly log text, use the overload without `Level` and it'll log as info.

**Again, if you give it an invalid file to output the log to, your computer will explode.**

EasyLogger is tied to CompilerDirectives.DEBUG in order to remove all logging commands from a distribution if you deactivate debug code. This is so logging doesn't bloat the system, since I use logging primarily for debugging.

PS.: It has an attribute called LEVEL. Change that and it'll change the minimum log level required for the logger to log. If you don't know what that means, keep it as INFO.

## ListFiles

Creates a list with the fully qualified name of all files in a directory tree. This one is relatively safe, but if your computer explodes, I take no responsibility.
