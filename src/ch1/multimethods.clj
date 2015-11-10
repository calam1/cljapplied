(ns ch1.multimethods
  (:require [schema.core :as s]
            [ch1.recipe]
            [ch1.recipe :refer (->Person)]
            [ch1.recipe :refer (->Ingredient)]
            [ch1.money :refer [+$ zero-dollars]])
  (:import [ch1.recipe Recipe]))

(s/defrecord Store
    [name :- s/Str
     manager :- Person])

(s/defn cost-of 
  [store :- Store ingredient :- Ingredient]
  (str (get store :name) (get ingredient :quantity)))

(def test-store
  (->Store
   "Marshall Fields"
           (->Person "Chris" "Lam")))

(def test-ingredient
  (->Ingredient "spaghetti" 1 :lb))

(defmulti cost (fn [entity store] (class entity)))

(defmethod cost Recipe [recipe store]
  (reduce +$ zero-dollars
          (map #(cost % store) (:ingredients recipe))))

(defmethod cost Ingredient [Ingredient store]
  (cost-of store Ingredient))
