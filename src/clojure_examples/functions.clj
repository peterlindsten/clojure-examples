(ns clojure-examples.functions)

;; Creation
(fn [params] (print params))

; These are equivalent
(def printer (fn [params] (print params)))
(defn printer [params] (print params))

; Arity overloading
(defn printer
  ([] (printer "What?!")) ; Calling another arity of ourselves
  ([params] (println params)))

; Variadic
(defn printer
  ([] (printer "What?!"))
  ([& params] (apply println params)))

;; Invocation
; As the first item in a list
((fn [params] (print params)) "Herro!")
(printer "Herro again!")
(printer)
(printer "Herro" "Variadic" "Function")

; Apply a sequence as a list of arguments
(apply println [1 3 2])
  ; Is the same as
(println 1 2 3)

;; Interop invocation
; These are macro-like, which expand according to http://clojure.org/reference/java_interop
(def s (Short. "3")) ; Short s = new Short("3")
(.floatValue s) ; s.floatValue()
(.-x (java.awt.Point. 1 2)) ; new Point(1, 2).x
Math/PI ; Math.PI
(Math/sqrt 9) ; Math.sqrt(9);

; Chaining method calls, fluent-style
(.. s floatValue intValue) ; s.floatValue().intValue();