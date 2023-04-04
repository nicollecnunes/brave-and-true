(ns brave-and-true.produtos)

; Desconto de 10% para valores > 100
(defn valor-descontado-maior-100
  "DOC: Retorna o valor com desconto de 10% para valores > 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))

    valor-bruto))

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

(println (map valor-descontado-maior-100 precos))
(println (range 10)) ;0 1 2 3 4 5 6 7 8 9 
(filter even? (range 10))  ;0 2 4 6 8

(reduce + precos)

(defn soma-verbose
  [n1 n2]
  (println "somando " n1 "e" n2)
  (+ n1 n2))

(reduce soma-verbose precos)
(reduce soma-verbose 0 precos) ; 0 e o valor inicial do acumulador

(reduce soma-verbose (range 10))