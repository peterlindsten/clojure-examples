(ns clojure-examples.variables-constants)

;; Lexical binding

(let [x 1
      y (+ x 7)]
  (println x y))

;; Dynamic? binding (not sure if terminology is correct)
;; Binds to current namespace: *ns*

(def x 1)
(def y "useless docstring" (+ x 7))
(def z) ; Unbound
(println x y z (:doc (meta #'y)))
