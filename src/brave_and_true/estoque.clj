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

(-> pedido
    :mochila
    :quantidade
    println) ;mesma coisa


(defn imprime-e-15
  [valor]
  (println "valor" valor)
  15)

(println (map imprime-e-15 pedido))

(defn imprime-e-15
  [[chave valor]] ;ja desestrutura o unico valor recebido em dois
  (println chave "e" valor)
  15)

(println (map imprime-e-15 pedido))

(defn retorna-valor
  [[_ valor]] ;ja desestrutura o unico valor recebido em dois
  valor)

(defn preco-dos-produtos ;quanto posso ganhar em cada
  [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(reduce + (map preco-dos-produtos pedido))


(def pedido {:mochila {:quantidade 10, :preco 80}
             :camisa {:quantidade 5, :preco 30}
             :chaveiro {:quantidade 10}})


(defn gratuito? ;se nao tiver preco, retorna 0. filtra os que o preco sao <= 0
  [[_ valor]]
  (<= (get valor :preco 0) 0))

(filter gratuito? pedido)

(defn pago?
  [item]
  (not (gratuito? item)))

(def pago2? (comp not gratuito?)) ;simbolo pago2? , sem parametro , nao