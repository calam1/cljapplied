(ns ch2.orders)

(defn new-orders clojure.lang.PersistentQueue/EMPTY)

(defn add-order
  [orders order]
  (conj orders order))

(defn cook-order
  [orders]
  (cook (peek orders))
  (pop orders))

