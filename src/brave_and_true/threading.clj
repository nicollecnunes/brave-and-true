(ns brave-and-true.threading)

(def products [{:id 1
                :name "Kettle"
                :type :appliance
                :stock-count 50
                :unit-size :small
                :price 100.40
                :status :active}
               {:id 2
                :name "Couch"
                :type :furniture
                :stock-count 20
                :unit-size :large
                :price 4599.00
                :status :active}
               {:id 3
                :name "Desk"
                :type :furniture
                :stock-count 40
                :unit-size :medium
                :price 1299.99
                :status :active}
               {:id 4
                :name "Toaster"
                :type :appliance
                :stock-count 100
                :unit-size :small
                :price 499.99
                :status :active}
               {:id 5
                :name "Bed"
                :type :furniture
                :stock-count 10
                :unit-size :large
                :status :active
                :price 1200
                :special? true}])

; filter of type furniture
(defn furniture?
  [item]
  (= (:type item) :furniture))

; filter of size large
(defn large?
  [item]
  (= (:unit-size item) :large))

;;;;;;;;;;;THREAD LAST;;;;;;;;;;;;
; standart use
(defn product-to-discount 
  [products]
  (first (reverse (sort-by :stock-count (filter large? (filter furniture? products))))))

(product-to-discount products) ; => Couch..

; ->> thread-last: takes the first value and passes as the last argument. the result is bein passed
(defn product-to-discount-tl
  [products]
  (->> products
       (filter furniture? ,,,)
       (filter large? ,,,)
       (sort-by :stock-count ,,,)
       (reverse ,,,)
       (first ,,,)))

(product-to-discount-tl products) ;=> Couch..
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;THREAD FIRST;;;;;;;;;;;;
; standart use
(defn sell-product
  [product buyer]
  (let [stock-count (:stock-count product)
        current-buyers (get :buyers product [])
        updated-buyers (conj current-buyers buyer)
        updated-stock-count (- stock-count 1)]
        (assoc (assoc product :stock-count updated-stock-count):buyers updated-buyers)))

(sell-product (products 0) "nicolle") ; => kettle stock-count 49, buyers nicolle

; -> thread-first: populates the first argument
(defn sell-product-tf
  [product buyer]
  (let [stock-count (:stock-count product)
        current-buyers (get :buyers product [])
        updated-buyers (conj current-buyers buyer)
        updated-stock-count (- stock-count 1)]
  (-> product
      (assoc ,,, :stock-count updated-stock-count)
      (assoc ,,, :buyers updated-buyers))))

(sell-product-tf (products 0) "nicolle") ; => kettle stock-count 49, buyers nicolle
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;AS THREAD;;;;;;;;;;;;
; as-> as-thread
; cond-> conditional-thread
; some-> some-thread