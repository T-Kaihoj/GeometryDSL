# Language guide

## Variables and assignment
The variables in this language is not constant, this is to allow the manipulation of state from nested scopes e.g. if statements.
However all variables are copied by value. This ensures that Assigning a new value to variable does not have
 side effects, such as changing sets that included the previous value. 
#Types
##bool
bool is a typical Boolean representation,And can be constructed either using a An expression that yields a Boolean 
result such as greater than(<) or using bool literals (true and false)
`b:bool := true`_Example: creating a variable **b** Which is a Boolean and has initial value of true_
##Integers
Integers is a recitation of Whole numbers Such as -3 or 10. 
`i:int := 12` _Example: creating a variable **i** Which is a integer and has initial value of 12_
##Reels
A mathematical representation of Real numbers, so the possibility of floating point errors does not exist in any operation.
`r:reel := 12`_Example: creating a variable **b** Which is a Boolean and has initial value of true_

##Custom types
It's possible in GDSL to define custom types, these consists of other types previously defined.
Recursion is not possible in gdsl, so it is not possible to include a custom type As a value in its own definition.
Custom types must be defined outside any scope, a definition consists of The key word "type" a type name and a comma separated list of names Type members.
`type <Name of type> (<Local name for variable>:<Type name of variable>)`.


`type point (x:int,y:int)`
_example creates a new Type, point consisting of two integers_

## Set 
#### Set construction
There are 3 different ways of constructing sets in GDSL.
##### set  construction using Literal
Set Literal is the easiest way to construct a set it's simply a comma separated lists of of values to be included in the new set all contained within `{ }`.
Note if a Set is included as one of the values its constituent members become members of the new set this is due to set nesting not being possible in GDSL.
`{12,10,2,{15,2,15} }`
##### set  construction using Comprehension
Is ways to construct from a existing set, Set Comprehension is able to can both Select
 The members of Original set that is required to be copied and to manipulate the to selected elements. Set comprehension consists of three parts 
`{ <elements part> | <Testing part>| <Manipulation part> }`
The **elements part** Is of the form `b in B ` Where B Is the name of asset available and current scope And b visa local name to be used in this statement and nested statements
The **test part**  contains an expression that will be evaluated For each element in the set and if true the element will be included in the new set after being modified. the test part is optional And if left out all elements of the original set will be copied. 
The **Manipulation part** contains expression that may manipulate the local Variable from the entity part.

`{ a in A | a > 15| a - 15 }`

##### Set construction using select
Functions is the same way as the said quantification described below Keyword selectWhich returns a set,
  all elements for which the  test part is true are included in a this set. |

#Functions
##set functions

#operations
##Comparison operators
These comparison operators all take two numbers and returns a boolean 
the functionality is described below:

| name | notation | description |
|---|---------|---------|
|Comparison	| '==' 	|Compares two numbers and returns true they are the same there might be floating-point eras  	|
|Not comparison  	| '!=' 	|  	Compares two numbers and returns false  they are the same there might be floating-point eras|
| Greater than or equal 	| '>=' 	| This operation returns true if the first number is greater or equal then the second number. 	|
| Less than than or equal 	| '<=' 	|This operation returns true if the first number is less or equal then the second number.  	|
| Greater than 	| '>' 	|   This operation returns true if the first number is greater then the second number.	|
| Less than 	| '<' 	|  This operation returns true if the first number is less then the second number. 	|

## Mathematical operations
| name | notation | description |
|---|---------|---------|
| Addition 	| + 	|  	|
| Subtraction 	|  - 	|  	|
| Division 	|  / 	|  	|
|  Multiplication	| * 	|  	|
| Exponent 	|  '^' 	|  	|

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