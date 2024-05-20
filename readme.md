# Lox4s (Crafting Interpreters - Part 1)

This repo implements an interpreter for the LOX programming language as per
the [Crafting Interpreters](https://craftinginterpreters.com/) book. It leverages Functional Programming techniques with
Scala libraries such as Cats and FS2 with the aim of improving the performance of the Java interpreter built in the
book.

## Definition of LOX

LOX is a high level programming language with C like syntax. The reason C style syntax is used is that most readers of
the book will be deeply familiar with it. Very much like Javascript, it is a dynamically typed, garbage collected
language.

```lox
// Your first Lox program!
print "Hello, world!";
```

### Data Types

LOX supports the following data types out of the box:

1. Boolean
2. Numbers (double precision floating points, supports integer and decimal syntax)
3. Strings
4. Nil (equivalent to `null` in other languages)

### Expressions


