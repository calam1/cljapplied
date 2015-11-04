(ns ch1.recipe
  (:require [schema.core :as s]))


(s/defrecord Ingredient
    [name     :- s/Str
     quantity :- s/Int
     unit     :- s/Keyword])

(s/defrecord Person
    [fname :- s/Str
     lname :- s/Str
     ])

(s/defrecord Recipe
    [name :- s/Str
     author :- [Person]
     description :- s/Str
     ingredients :- [Ingredient]
     steps :- [s/Str]
     servings :- s/Int
     ])

(def toast
  (->Recipe
   "Toast"
   (->Person "Chris" "Lam") ;;nested
   "Crispy bread"
   ["slice of bread"]
   ["toast bread in toaster"]
   1))

(def people
  {"p1" (->Person "Christopher" "Lam")})

(def recipes
  {"r1" (->Recipe
         "Toast"
         "p1" ;; person id
         "Crispy bread"
         ["slice of bread"]
         ["toast bread in toaster"]
         1
         )})

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
