# GeometryDSL

## Generating Parser
1. Setup ANTLR accourding to [The ANTLR Mega Tutorial](https://tomassetti.me/antlr-mega-tutorial).
2. run command `antlr4 Gdsl.g4 -o ./src/parser/ -package parser -visitor` from project root.

## Setting up Z3
1. Download `com.microsoft.z3.jar` and `libz3java.sp` from Z3 github repo and place them in an appropriate folder.
2. If you are using IntelliJ Idea, add `com.microsoft.z3.jar` as a project dependency.
3. (Linux) Export the folder where the files are placed to the `LD_LIOBRARY_PATH` environment variable.
