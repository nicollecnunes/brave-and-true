(ns Exercism.clojure.others.params)

(defn welcome
  ([name]
   (welcome name "Nunes"))
  ([name surname]
   (str "Welcome, " name " " surname)))
;; => #'brave-and-true.params/welcome

(welcome "Nicolle")
;; => "Welcome, Nicolle !"

(welcome "Nicolle" "Nunes")

(defn welcomes [name & friends]
  (println "amigos " friends)
  (str "Welcome!! " name ", and friends: " friends))

(welcomes "Nicolle")
;; => "Welcome!! Nicolle, and friends: "


;(defn [param1 param2 & optional])