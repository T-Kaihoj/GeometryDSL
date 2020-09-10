# GeometryDSL

## Generating Parser
1. Setup ANTLR accourding to [The ANTLR Mega Tutorial](https://tomassetti.me/antlr-mega-tutorial).
2. run command `antlr4 Gdsl.g4 -o ./src/parser/ -package parser -visitor` from project root.

## Setting up Z3
1. Download `com.microsoft.z3.jar` and `libz3java.so` from Z3 github repo and place them in an appropriate directory.

    On Linux is appropriate directory `/usr/local/lib`
    
2. Add the directory to the java linker path.
    
    On Linux: Add the line `export LD_LIBRARY_PATH$LD_LIBRARY_PATH:/usr/local/lib` to your `.bash_profile` file.
    (Also ensure the correct packages are installed.
    Not sure which, but try: `z3` and `z3-devel`.
    
3. If you are using IntelliJ Idea, add `com.microsoft.z3.jar` as a project dependency.
