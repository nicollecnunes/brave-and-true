(ns brave-and-true.myreduce)

(defn contador
  [qtd-elems elems-rest]
  (if (seq elems-rest)
    (recur (inc qtd-elems) (next elems-rest))
    qtd-elems))
