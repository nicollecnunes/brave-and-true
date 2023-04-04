(ns brave-and-true.estoque)

(def estoque {"mochila" 10
              "camisa" 5})

(println "temos" (count estoque) "itens")
(println "os itens são" (keys estoque))

; keyword
; :mochila

(def estoque {:mochila 10
              :camisa 5})

(assoc estoque :cadeira 3)
(assoc estoque :mochila 1) ; sobrescreve

(update estoque :mochila inc) ;mochila soma mais 1

(defn tira-um
  [valor]
  (println "tirando 1 de" valor)
  (- valor 1))

(update estoque :mochila tira-um)

(def pedido {:mochila {:quantidade 10, :preco 80}
             :camisa {:quantidade 5, :preco 30}})


(def pedido (assoc pedido :chaveiro {:quantidade 5, :preco 5}))
(println pedido)
(println pedido :mochila)
(println (get pedido :mochila))
(println (get pedido :cadeira {}))

(println (:mochila pedido)) ; mesma coisa
(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

;threading
(println(-> pedido
    :mochila
    :quantidade))
