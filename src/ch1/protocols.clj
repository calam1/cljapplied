(ns ch1.protocols
  (:require [ch1.recipe]
            [ch1.multimethods :refer [cost-of]]
            [ch1.money :refer [+$ zero-dollars]])
  (:import [ch1.recipe Recipe]
           [ch1.recipe Ingredient]))


(defprotocol Cost
  (cost [entity store]))

(extend-protocol Cost
  Recipe
  (cost [recipe store]
    (reduce +$ zero-dollars
            (map #(cost % store) (:ingredients recipe))))
  Ingredient
  (cost [Ingredient store]
    (cost-of store Ingredient)))
