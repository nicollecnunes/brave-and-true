(ns nucleotide-count
  (:require [clojure.string :as str]))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (str/includes? "GACT" (str nucleotide))
    (get (frequencies strand) nucleotide 0)
    (throw (AssertionError. "Wrong input."))))


(defn nucleotide-counts [strand] 
  (let [countG (count-of-nucleotide-in-strand \G strand)
        countA (count-of-nucleotide-in-strand \A strand)
        countC (count-of-nucleotide-in-strand \C strand)
        countT (count-of-nucleotide-in-strand \T strand)]

    (if (= (count strand) (+ countA countC countG countT))
      (hash-map \A countA \T countT \C countC \G countG) 
      (str "error"))))
