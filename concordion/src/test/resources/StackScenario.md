# Stack Scenarios
In order to develop an application that requires a stack efficiently
As a development team
I would like to use an interface and implementation in Java directly

## Scenario: Basic functionality of a Stack
Given an [empty stack](- "emptyStack()")   
When I add [Java](- "push(#TEXT)")  to the stack  
and [C++](- "push(#TEXT)")  
When I [pop](- "#result = pop()") the stack 
I expect the value to be [C++](- "?=#result")

## Scenario: Stack search
Given an [empty stack](- "emptyStack()")  
When the string [Java](- "push(#TEXT)") is added  
And the string [C++](- "push(#TEXT)") is added  
And the string [PHP](- "push(#TEXT)")is added  
And the element [Java](- "#result=search(#TEXT)") is searched for  
Then the position returned should be [3](- "?=#result")
