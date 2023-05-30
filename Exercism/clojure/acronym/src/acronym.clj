(ns acronym
  (:require [clojure.string :as str]))

(defn acronym-ugly
  "Converts phrase to its acronym."
  [phrase]
  (str/upper-case (apply str (map (fn [p] (first p)) (re-seq #"[A-Z]+[a-z]*|[a-z]+" phrase)))))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->> phrase
       (re-seq #"[A-Z]+[a-z]*|[a-z]+")
       (map first)
       (apply str)
       (str/upper-case)))
