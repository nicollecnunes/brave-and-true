(ns Exercism.clojure.others.exs0305)

(defn hello
  [name]
  (str "hello, " name))

(defn mult
  ([n1]
   (mult n1 n1))
  ([n1 n2]
   (* n1 n2)))

(mult 2)
(mult 5 4)

(defn multmult
  [& args]
  (reduce mult args))

(multmult 2 4 5 8 7 5)