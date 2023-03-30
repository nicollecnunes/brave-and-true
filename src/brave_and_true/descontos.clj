(ns brave-and-true.descontos)

; Desconto de 10% para qualquer valor
(defn valor-descontado
  "DOC: Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "Calculando desconto de" desconto)
    (- valor-bruto desconto)))

; Desconto de 10% para valores > 100
(defn valor-descontado2
  "DOC: Retorna o valor com desconto de 10% para valores > 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))

     valor-bruto))

(valor-descontado2 100)
(valor-descontado2 900)
