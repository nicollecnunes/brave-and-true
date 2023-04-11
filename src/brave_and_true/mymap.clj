(ns brave-and-true.mymap)

(map println ["nicolle1" "nicolle2" "nicolle3"]) ; -> ("nicolle1" "nicolle2" "nicolle3")
(println (first ["nicolle1" "nicolle2" "nicolle3"])) ;-> "nicolle1"
(println (rest ["nicolle1" "nicolle2" "nicolle3"])) ; ->  ("nicolle2" "nicolle3")
(println (rest [])) ; ->  ()
(println (next ["nicolle1" "nicolle2" "nicolle3"])) ; ->  ("nicolle2" "nicolle3")
(println (next [])) ; ->  nil



; println "nicolle2" "nicolle3"
; println "nicolle3"
; println "nicolle3"
; println 

(defn mymap
  [fn lista]
  (let [primeiro (first lista)]
    (if (not (nil? primeiro))
      (do (fn primeiro)
          (mymap fn (rest lista))))
    ))

