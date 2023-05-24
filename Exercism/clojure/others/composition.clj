(ns Exercism.clojure.others.composition)

((comp #(/ % 2) #(* % 100)) 25) ; => 1250

(-> 25
 (/ 2)
 (* 100))

(defn talk-to 
  [talk]
  (fn [to]
    (str talk " " to)))

(talk-to "Oi, ") ;=> retorna uma funcao
((talk-to "Oi, ") "Nicolle") ;=> oi, nicolle

