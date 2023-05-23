(ns bob
  (:require [clojure.string :as str]))

(defn get-text [s]
  (apply str (filter #(Character/isLetter %) s)))

(defn all-uppercase? [s]
  (if (seq (get-text s))
    (= (get-text s) (str/upper-case (get-text s)))
    false)
  )

(defn is-question? [s]
  (= (subs (str/trim s) (- (count (str/trim s)) 1)) "?"))

(defn response-for [s] ;; <- arglist goes here
  (cond
    (empty? (str/trim s)) "Fine. Be that way!"
    (and (is-question? s) (all-uppercase? s)) "Calm down, I know what I'm doing!"
    (is-question? s) "Sure."
    (all-uppercase? s) "Whoa, chill out!"
    :else "Whatever."))
