(ns brave-and-true.composition)

((comp #(/ % 2) #(* % 100)) 25) ; => 1250

(-> 25
 (/ 2)
 (* 100))