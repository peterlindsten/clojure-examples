(ns clojure-examples.functions)

;; Creation
(fn [params] (print params))

; These are equivalent
(def printer (fn [params] (print params)))
(defn printer [params] (print params))

; "private" functions
(defn ^:private my-private []
  (println "I'm private!"))
(defn- my-private []
  (println "I'm private")) ; Shorthand of above

; Arity overloading
(defn printer
  ([] (printer "What?!")) ; Calling another arity of ourselves
  ([params] (println params)))

; Variadic
(defn printer
  ([] (printer "What?!"))
  ([& params] (apply println params)))

; Named arguments
; Note: this is just destructuring the & rest argument collection
(defn address-printer [name & {:keys [street zip city]}] ; the & is required for this to work like named arguments, otherwise it just destructures a map in the position
  (println name)
  (when street (println street)) ; (when) fails if parameter is nil
  (when zip (println zip))
  (when city (println city)))

;; Invocation
; As the first item in a list
((fn [params] (print params)) "Herro!")
(printer "Herro again!")
(printer)
(printer "Herro" "Variadic" "Function")

; With named arguments
(address-printer "Oskar Götesson" :city "Götet")

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