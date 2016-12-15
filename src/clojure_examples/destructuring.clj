(ns clojure-examples.destructuring)

;;; Destructuring - Taking apart collections with easy syntax

; Destructuring works basically the same for let, defn and fn

;; Sequential

(let [[a b c] [1 2 3]]
  (println a b c))

(let [[a b] [1 2 3]] ; Extra values are ignored
  (println a b))

(let [[a b c d] [1 2 3]] ; Extra bindings become nil
  (println a b c d))

(let [[a & rest] [1 2 3]] ; Rest becomes a list (or seq?)
  (println a)
  (println rest))

(let [[_ & rest] [1 2 3]] ; Idiomatically ignoring values with _
  (println rest))

;; Associative

(let [{a :a b :b} {:a 12 :b 13}] ; The first {] is not a map, but a destructuring form, binding a to :a and b to :b
  (println a b))

(let [{a :a} {}] ; Binding to non-existant keys: nil
  (println a))

(let [{:keys [a b]} {:a 1 :b 2}] ; Shorthand for a :a b :b
  (println a b))

(let [{:keys [a b c]
       :or {b 2 c 3}} {}] ; Providing default values, should they not exist
  (println a b c))

; Note: there are also :syms and :strs which bind from symbols and strings respectively
