# Language Documentation
The GDSL (Geometric Domain Specific Language) is described here.

## Program Definition


## Variables and Assignment
The variables in this language are not constant, this is to allow the manipulation of state from nested scopes e.g. if statements.
However all variables are copied by value.
This ensures that assigning a new value to variable does not have side effects, such as changing sets that included the previous value.

Example of how to define and assign a value to a variable using the `:=` symbol:
```
<varName>: <varType> := <value>
```

# Types
## Booleans
A boolean value is specified using the `bool` keyword and can take one of the two values `true` or `false`.

Example: `b: bool := true`

## Integers
A whole number, specified with the `int` keyword.

Example: `i: int := 3`

## Reals
A mathematical representation of real numbers, so the possibility of floating point errors does not exist in any operation.
Specified with the `real` keyword.

Example: `r: real := 12.32`

## Sets
Sets are unsorted collections of values of other types.
The `set` keyword is used to specify the set type.
Each element in a set is unique, that is, it cannot contain identical values.
Sets in GDSL cannot contain other sets, so specifying the set `{1, {2}}` will be flattened to `{1, 2}`.

There are 3 different ways of constructing sets in GDSL.

##### Set construction using Set Literals
Set literals are a comma separated list of value contained withing `{ }`. 

Example: `A: set := {2, 4, 6}`

##### Set construction using Select expressions
Select expressions are used to construct a new set from already an existing set.
Given a set of values, it will collect all the elements of the set complying with a condition.

The general form of select expressions look like this: `select( <element> in <set> , <condition> )`.

Example:
```
nums: set := {1, 2, 3, 4, 5}
largeNums: set := select(n in nums, n > 2)
largeNums == {3, 4, 5}
```

##### Set construction using Set Comprehensions
Set Comprehensions do the same as select statements, but with the addition of being able to do use the selected element to construct the new set.
The syntax of a set comprehension looks like this: `{ <element> in <set> | <condition> | <manipulation> }`.
- The `element` is a local variable used as a placeholder for the elements of in the `set`.
- The `condition` is an expression which should result in a `true` or `false` value, indicating whether the element should be used to construct the new set.
- The `manipulation` is an expression with uses the `element` variable to construct elements for the new set.

Example:
```
x: set := {n in {1, 2, 3, 4} | 1 < n | n * n}
x == {4, 9, 16}
```

## User Defined Types
User defined consists of one or more name, public fields of previously defined types.
Recursively defined types are not possible.
They must be defined in the program definition and cannot be defined inside methods or other code blocks.

An example of a Point type can be seen here:
```
type Point(x: int, y: int)
```

#### Invariant
Invariants can be defined for types using the `inv` keyword.
If an object of a given type is constructed with values which does not adhere to the invariant, is an empty set returned instead.

An example of an invariant for circles, specifying that its radius must be larger than zero, can be seen here:
```
type Circle(x: int, y: int, r: int)
inv r < 0
```

## Type Checking
It is possible to check the type of variables at runtime using the `is` operator.
For example will `4 is int` return `true` while `5.4 is bool` will return `false`.
Type checking also works for user defined types.

Type checking can be used to select all the elements of a particular type from a set:
```
nums: set := {1, 2.2, 6, 7.4}
reals: set := select(n in nums, n is real)
reals == {2.2, 7.4}
```

#Functions
##set functions

#operations
##Comparison operators
These comparison operators all take two numbers and returns a boolean 
the functionality is described below:

| Name | Notation | Description |
|---|---------|---------|
|Comparison	| '==' 	|Compares two numbers and returns true they are the same there might be floating-point eras  	|
|Not comparison  	| '!=' 	|  	Compares two numbers and returns false  they are the same there might be floating-point eras|
| Greater than or equal 	| '>=' 	| This operation returns true if the first number is greater or equal then the second number. 	|
| Less than than or equal 	| '<=' 	|This operation returns true if the first number is less or equal then the second number.  	|
| Greater than 	| '>' 	|   This operation returns true if the first number is greater then the second number.	|
| Less than 	| '<' 	|  This operation returns true if the first number is less then the second number. 	|

## Mathematical operations
| Name | Notation | Description |
|---|---------|---------|
| Addition 	| + 	|  	|
| Subtraction 	|  - 	|  	|
| Division 	|  / 	|  	|
|  Multiplication	| * 	|  	|
| Exponent 	|  ^ 	|  	|

##Boolean connectors

## Set Operations
### Set Union 
Takes mathematical union between two sets
`{10,20} union {12,10} //Result: {10,12,20}`
### DIFFERENCE
Takes a symmetric difference between two sets, In other words the new set only contains elements that are in one set not both of the sets,
`{10,20} DIFFERENCE {12,10} //Result: {12,20}`
### INTERSECTION
Intersection Operates on two sets and returns a set containing all elements that are in both sets
`{10,20} INTERSECTION {12,10} //Result: {10}`
### set quantifier
A set quantifier is a way of creating a subset based on list of criteria.
Qualification statement consists of a keyword,elements part and test part.
`<Keyword>(<elements part> , <test part>)`
The **elements part** Is of the form `b in B ` Where B Is the name of asset available and current scope And b visa local name to be used in this statement and nested statements
The **test part**  Contents and expression that will be evaluated as a Boolean and And issues in conjunction with the keyword to determine the outcome of the quantifier

` exist(a in A, a >15)`
_This statement will return true if they exists an element A that is larger than 15._

The keyword part can be one of the following:

|**Keyword**   | **Description**  |
|:---|---------|
| exist  | returns true if there is at least one element for which the test part is true, otherwise it returns false  |
|  all | returns true if for every element the test part is true, otherwise it returns false |


### set size / cardinality #Not Yet implement
### Subset #Not Yet implement
### Strict subset #Not Yet implement
### choose
The choose operator returns an element from a set,The language makes no guarantee of which element will be returned
`choose {12,15 ,54 ,15} //result Might be : 54`
###dotExp
###absoluteExp
###parenthesisExp

# Control flow
##switch
