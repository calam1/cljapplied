(ns catalog-import.core.clj)

(defn import-catalog
  [data]
  (reduce #(conj %1 %2) [] data))

(defn import-catalog-fast
  [data]
  (persistent!
   (reduce #(conj! %1 %2) (transient []) data)))

