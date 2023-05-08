(ns accumulate)

(defn accumulate
  [fn lista]
  (let [primeiro (first lista)
        outros (rest lista)]
    (cond
      (empty? lista) (vector)
      (empty? outros) (vector (fn primeiro))
      :else (into (vector (fn primeiro)) (accumulate fn outros)))))
