import java.util.Stack

Feature: Stack

        In order to develop an application that requires a stack efficiently
        As a development team
        I want like to use an interface and implementation in Java directly

        Scenario: Basic functionality of a Stack
        val stack = new Stack()
        Given an empty stack
          stack.size() => 0
        When the string "Java" is added
        stack.push(args.first)
        And the string "C++" is added
        Then the size should be "2"
        stack.size() => args.first.toInt