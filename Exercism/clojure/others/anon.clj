(ns Exercism.clojure.others.anon)

(defn say-hello
  [name]
  (str "Hello, " name))

(map #(str "Hello, " %) ["World" "Earth" "Mars" "Nicolle"])
(map say-hello ["World" "Earth" "Mars" "Nicolle"])