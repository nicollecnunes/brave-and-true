(ns anagram 
  (:require [clojure.string :as str]))

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (filter #(and (not (= (str/lower-case word) (str/lower-case %))) (= (frequencies (str/lower-case word)) (frequencies (str/lower-case %)))) prospect-list))
