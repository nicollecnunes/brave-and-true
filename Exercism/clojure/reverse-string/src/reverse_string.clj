(ns reverse-string 
  (:require [clojure.string :as s]))

(defn reverse-string-standart [s] ;; <- arglist goes here
  (apply str (reverse s))
)

(defn reverse-string [s] ;; <- arglist goes here
  (->> s
      (reverse)
      (apply str)))
