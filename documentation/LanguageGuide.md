# Language guide



## Set 
### Set construction
There are 3 different ways of constructing sets in GDSL.
#### set  construction using Literal
Set Literal is the easiest way to construct a set it's simply a comma separated lists of of values to be included in the new set all contained within `{ }`.
Note if a Set is included as one of the values its constituent members become members of the new set this is due to set nesting not being possible in GDSL.
`{12,10,2,{15,2,15} }`
#### set  construction using Comprehension
Is ways to construct from a existing set, Set Comprehension is able to can both Select
 The members of Original set that is required to be copied and to manipulate the to selected elements. Set comprehension consists of three parts 
`{ <elements part> | <Testing part>| <Manipulation part> }`
The **elements part** Is of the form `b in B ` Where B Is the name of asset available and current scope And b visa local name to be used in this statement and nested statements
The **test part**  contains an expression that will be evaluated For each element in the set and if true the element will be included in the new set after being modified. the test part is optional And if left out all elements of the original set will be copied. 
The **Manipulation part** contains expression that may manipulate the local Variable from the entity part.

`{ a in A | a > 15| a - 15 }`

#### Set construction using select
Functions is the same way as the said quantification described below Keyword selectWhich returns a set,
  all elements for which the  test part is true are included in a this set. |

## Set Operations
#### Set Union 
Takes mathematical union between two sets
`{10,20} union {12,10} //Result: {10,12,20}`
#### DIFFERENCE
Takes a symmetric difference between two sets, In other words the new set only contains elements that are in one set not both of the sets,
`{10,20} DIFFERENCE {12,10} //Result: {12,20}`
#### INTERSECTION
Intersection Operates on two sets and returns a set containing all elements that are in both sets
`{10,20} INTERSECTION {12,10} //Result: {10}`
#### set quantifier
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


#### set size / cardinality #Not Yet implement
#### Subset #Not Yet implement
#### Strict subset #Not Yet implement
#### choose
The choose operator returns an element from a set,The language makes no guarantee of which element will be returned
`choose {12,15 ,54 ,15} //result Might be : 54`




## Variables and assignment
The variables in this language is not constant, this is to allow the manipulation of state from nested scopes e.g. if statements.
However all variables are copied by value. This ensures that Assigning a new value to variable does not have
 side effects, such as changing sets that included the previous value. 
## Typical types

##Custom types
`type point (x:number,y:number)`
type checking and filtering
##Functions

##set functions

## Mathematical operations