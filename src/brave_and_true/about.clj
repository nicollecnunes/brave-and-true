(ns brave-and-true.about)

(defn describenumber
  [number]
  (cond-> []
    (pos? number) (conj "positive")
    (neg? number) (conj "negative")
    (even? number) (conj "even")
    (odd? number) (conj "odd")))