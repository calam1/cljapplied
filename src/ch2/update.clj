(ns ch2.update
  (require [medley.core :refer (map-vals)]
           [ch1.recipe :refer [->Ingredient]]
           [ch1.recipe :refer (map->Recipe)]))

(defn keywordize-entity
       [entity]
       (map-keys keyword entity))

(defn compute-calories
  [entity]
  300)

(defn- update-calories
  [recipe]
  (assoc recipe :calories (compute-calories recipe)))


(defn include-calories
  [recipe-index]
  (map-vals update-calories recipe-index))

(def spaghetti-tacos
  (map->Recipe
   {:name "Spaghetti tocos"
    :description "It's spaghetti ... in a taco."
    :ingredients [(->Ingredient "Spaghetti" 1 :lb)
                  (->Ingredient "Spaghetti sauce" 16 :oz)
                  (->Ingredient "Taco shell" 12 :shell)]
    :steps ["Cook spaghetti according to box."
            "Heat spaghetti sauce until warm."
            "Mix spaghetti and sauce."
            "Put spaghetti in taco shells and serve."]
    :servings 4}))

