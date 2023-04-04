(ns brave-and-true.produtos)

(def precos [30 700 20])

(println (precos 0))
(println (get precos 0))

(println (get precos 10000)) ; retorna nil quando não tem
(println (get precos 10000 -1)) ; retorna -1 quando não tem

(println (conj precos 50)) ; conj adiciona no final, mas nao altera preços

(update precos 0 inc) ; atualiza precos na posicao 0, somando 1
(update precos 1 dec) ; atualiza precos na posicao 1, subtraindo 1

(defn my-inc
  [valor]
  (+ valor 1))

(update precos 0 my-inc) ; atualiza precos na posicao 0, somando 1
