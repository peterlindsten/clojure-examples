(ns clojure-examples.namespaces)

;; Qualifying symbols

java.lang.Math/PI

:x ; Global keyword
::x ; Keyword in current namespace, qualified, shorthand. Exapnds into:
:clojure-examples.namespaces/x

;; Changing namespace

(in-ns 'user) ; Most useful in REPL, also creates ns if does not exist

;; "Importing"

(require 'clojure.set) ; Does not merge into current ns unlike Java import;
(clojure.set/union #{1 2 3} #{2 3 4})

(require '[clojure.set :as set]) ; alias
(set/union #{1 2 3} #{2 3 4})

(use 'clojure.set) ; Loads and merges into current ns, much like Java import - might get really confusing
(union #{1 2 3} #{2 3 4})

(use '[clojure.set :only (union)]) ; Loads and merges the specified funtions into current ns, much like Java static import
(union #{1 2 3} #{2 3 4})

(import (java.io File FileReader)) ; Import Java classes, no * support

; ns "macro" (Does not (macroexpand-1))
(ns clojure-examples.namespaces) ; Imports clojure.core & java.lang
(ns clojure-examples.namespaces
  (:require [clojure.set :as set])) ; (require) shortform
(ns clojure-examples.namespaces
  (:use [clojure.set :only (union)])) ; (use) shortform
(ns clojure-examples.namespaces
  (:import (java.io File FileWriter))) ; (import) shortform

;; Introspection

(ns-map 'clojure.set) ; All symbols availiable in ns, including imported etc.

(ns-interns 'clojure.set) ; Interned vars
(ns-publics 'clojure.set) ; Public vars
(ns-imports 'clojure.set) ; imported vars
(ns-refers 'clojure.set) ; referred vars (imports from other clojure ns)
(ns-aliases 'clojure.set)
(clojure.repl/dir clojure.set) ; same as (sort (ns-publics)), except prints instead of returns

;; Reloading

(require 'clojure.set :reload-all) ; Reload deps 1-level deep

;; Obtaining the ns symbol

(the-ns 'clojure.core)
