(ns anagram 
  (:require [clojure.string :as str]))

(defn different?
  [w1 w2]
  (not (= (str/lower-case w1) (str/lower-case w2))))

(defn anagram?
  [w1 w2]
  (= (frequencies (str/lower-case w1)) (frequencies (str/lower-case w2))))

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (->> prospect-list
       (filter #(different? word %))
       (filter #(anagram? word %))))
