(ns brave-and-true.descontos)

; Desconto de 10% para qualquer valor
(defn valor-descontado-todo-valor
  "DOC: Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "Calculando desconto de" desconto)
    (- valor-bruto desconto)))

(defn deve-aplicar-desconto?
  [valor-bruto]
  (> valor-bruto 100))

; Desconto de 10% para valores > 100
(defn valor-descontado-maior-100
  "DOC: Retorna o valor com desconto de 10% para valores > 100"
  [valor-bruto]
  ((deve-aplicar-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))

     valor-bruto))

(valor-descontado-maior-100 100)
(valor-descontado-maior-100 900)
