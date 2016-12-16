(ns clojure-examples.sequences)

; Sequences are the abstraction for iteration
; Sequences, unlike collections do not know their (count), as such (count) is O(n)
; Sequences may be lazy
; Sequences may be infinite
; In this way, they are much like Java streams
; Sequence objects are printed like lists

;; Creation

(seq [1 2 3])
(seq []) ; nil

(lazy-seq [1 2 3])
(lazy-seq []) ; ()

;; Manipulation
; These all call seq, and as such, returns a seq

(first [1 2 3])
(first []) ; nil

(rest [1 2 3])
(rest []) ; ()

(cons 0 [1 2 3])

; These are similar, but does not call seq

(next [1 2 3]) ; aka non-lazy (rest)
(next []) ; nil

