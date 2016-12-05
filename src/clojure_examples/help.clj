(ns clojure-examples.help)
(use 'clojure.repl) ; These commands are really for the repl

;; looks up function signature + docstring by name
(doc if)

;; looks up functions based on search pattern, matching name or docstring
(find-doc "sequence")

;; looks up functions based on search pattern, matching name
(apropos "if")

;; looks up source of functions or macros by name
;; does not work for special forms
(source when)

;; lists functions by namespace
(dir clojure.repl)
