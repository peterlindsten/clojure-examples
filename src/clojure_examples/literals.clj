(ns clojure-examples.literals)

;; Note that some of the "extra" information is preseved when printed, such as 42N which might aswell be a long

(println "Numbers")
(println 42 "\t\tlong, default integer")
(println 3.14e0 "\tdouble, default floating point")
(println 42N "\tBigInt for larger than 64 bit ints")
(println 1.0M "\tBigDecimal, which by default has exact decimal representation")
(println 22/7 "\tratio")

(println "\nOther non-structure literals")
(println "String" "\t\tString, much like any other language")
(println \e "\t\t\tcharacter, slightly different from Java")

(println true false "\tboolean literals, as usual")
(println nil "\t\tnull in other languages")
(println '+ 'Fr '*bob* "\ta variety of symbols, can contain more characters than you might be used to")
;; ' is syntactic sugar for (quote ) which makes the reader NOT evaluate the expression - avoids exceptions here
;; *value* denotes Mutable bindings - this is only a convention
(println :alfa :bet "\tkeywords, commonly used as keys in maps")

(println "\nData structers")
(println '(4 :alpha 3.0) "\t\tList, the most basic structure in any LISP - high performance head-operations - linear time access")
(println [2 "hello" 99] "\t\tVector, the most commonly used structure in clojure, similar to arrays - high performance tail-operations, constant time access")
(println {:a 1 :b :3, :c "x"} "Map, key-value pairs - note that , doesnt mean anything to clojure, it is treated as whitespace")
;; Printout contains commas
(println #{3N :bob "max"} "\t\tSet, collection of unique items")
;; Note the print order of the Set - may not be the same as input order
