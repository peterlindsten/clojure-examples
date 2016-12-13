(ns clojure-examples.builtin-collections)

;; Lists
; Lists are singly-linked-lists
; Prepend is O(1)
; Lookup is O(n), with head naturally being O(1)

() ; Empty list, no need to quote
(list 1 2 3)
'(1 2 3)

(conj '(2 3) 1) ; New list (1 2 3), prepends head for performance reasons
(nth '(1 2 3) 0) ; get 0th value
; (get) does not work with lists

;; Vectors
; Indexed, Array-like
; Append is O(1)
; Lookup is O(1)

[]
(vector 1 2 3)
[1 2 3]
(vec '(1 2 3))

(conj [1 2] 3) ; New vector [1 2 3], appends tail for performance reasons

(nth [1 2 3] 0) ; Get nth element
(get [1 2 3] 0) ; Treats vector as map with keys 0 1 2..
(contains? [1 2 3] 3) ; Treats vector like a map with index being keys. This returns false

;; Maps
; Key->Value, hashtable, dictionary
; Normally unordered
; Insert and lookup: O(1)
; Techincally array-map when small, hash-map when large
; Note: sorted-map also exists, which is a tree map

{}
{:a 1 :b 2} ; Keys are idiomatically keywords
{"a" 1, "b" 2} ; Other things may be used for keys

(assoc {:a 1} :b 2) ; "Add"
(dissoc {:a 1} :a) ; "Remove"
(conj {:a 1} [:b 2]) ; "Add"

(:a {:a 1 :b 2}) ; get shortform - Only works when keywords are the keys
({:a 1 :b 2} :a) ; this is the same
(get {:a 1 :b 2} :a)
(contains? {:a 1} :a) ; true or false
; (nth) does not work with maps, not even sorted ones

; Nested

(def jdoe {:name "Joe Doe" :address {:zip 23132}})

(get-in jdoe [:address :zip]) ; access

(assoc-in jdoe [:address :zip] 24000) ; 'change' assoc-style

(update-in jdoe [:address :zip] inc) ; 'change' with a changer-function

;; Sets
; Collection of unique items
; hash-set when created by literal #{} notation
; sorted-set also exists
; Insert and lookup (member?): O(1)

#{}
#{:a :b}

(conj #{1 2} 3)
(disj #{1 2} 2) ; => #{1}

(:a #{:a :b}) ; Much like maps
(#{:a :b} :c) ; Returns nil if not a member
(contains? #{:a 'b} 'b) ; Returns true or false instead of the member
