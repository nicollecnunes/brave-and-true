(ns phone-number)

(defn nor-zero-nor-one
  [number]
  (and (not (= number \1)) (not (= number \0))))

(defn number [num-string] ;; <- arglist goes here
  (let [numbers (apply str (filter #(#{\0,\1,\2,\3,\4,\5,\6,\7,\8,\9} %) num-string))
        prim (first numbers)
        exchange (nth numbers 3)]
    (cond
      (and (= 11 (count numbers)) (= prim \1)) (subs numbers 1)
      (and (= 10 (count numbers)) (nor-zero-nor-one prim) (nor-zero-nor-one exchange)) numbers
      :else "0000000000")))

(defn area-code [num-string] ;; <- arglist goes here
  (let [phone (number num-string)]
    (cond
      (= 11 (count phone)) (subs phone 1 4)
      :else (subs phone 0 3))))

(defn pretty-print [num-string] ;; <- arglist goes here
  (let [area (area-code num-string)
        phone (number num-string)]
    (cond
      (= 11 (count phone)) (str "(" area ") " (subs phone 4 7) "-" (subs phone 7))
      :else (str "(" area ") " (subs phone 3 6) "-" (subs phone 6)))))
