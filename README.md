# GeometryDSL

GDSL (Geometric Domain Specific Language) is a programming language designed specifically for geometric programming and algorithms.

Documentation of the language can be found in [documentation/languageDocumentation.md](documentation/languageDocumentation.md).

## Program Execution
Running a program: 

```
$ java -jar GeometryDSL.jar <fileName>.gdsl -e
```

Porgram options:

| Option                   | Description |
|:---                      |:---         |
| `-e` / `--execute`       | Executes the provided program. |
| `-o` / `--optimize`      | Optimizes the provided program before execution and transpilation. |
| `-t` / `--transpile`     | Transpiles the program to an equivalent python program. |
| `--test`                 | Tests the program with an internal sample file to validate the installation. When this flag is used are all other options ignored. |
| `--function=*`  | Used to specify the entry function of the program. If non is provided, will `main` be used as standard. |
| `--infolevel=*` | Specifies which level of logged messages should be displayed. `error`, `warning`, and `info` are the possible levels. If non is provided, is `warning` used as standard. |

# Instructions to compile the source code

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
