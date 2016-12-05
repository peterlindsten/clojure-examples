(ns clojure-examples.syntactic-sugar)

(def foo 1)

;; The left-hand version is short-hand for the right-hand

(println 'foo (quote foo)) ; Do not evaluat
(println #'foo (var foo)) ; Get the var, not the contents
(println @#'foo (deref #'foo)) ; Get the contents, blocking if necessary
(println #(+ % 5) (fn [x] (+ x 5))) ; Lambda (Note that these are distinct when evaulated)
(println ^{:key "value"} [1 2] (with-meta [1 2] {:key "value"}))
(println ^:key [1 2] (with-meta [1 2] {:key true}))
(println #"regex.*" (re-pattern "regex.*"))

;; Todo: add others. What to do about non-substituting reader macros?
