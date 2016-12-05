(ns clojure-examples.metadata)

;; Metadata in clojure is a way to store extra information about things
;; Docstrings are stored this way

;; Setting metadata with a macro
(println (with-meta [1 2 3] {:example true}))

;; Reading metadata
(println (meta (with-meta [1 2 3] {:example true})))
