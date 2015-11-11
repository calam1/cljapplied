(ns ch3.orbital)

(defn semi-major-axis
  [p]
  (/ (+ (:aphelion p) (:perihelion p)) 2))

(def G 2)

(defn mu
  [mass]
  (* G mass))

(defn orbital-period
  [p mass]
  (* Math/PI 2
     (Math/sqrt (/ (Math/pow (semi-major-axis p) 3)
                (mu mass)))))

(defn orbital-periods
  [planets star]
  (let [solar-mass (:mass star)]
    (map (fn [planet] (orbital-period planet solar-mass)) planets)))

(defn orbital-period-transformation
  "create a map transformation for planet->orbital-perios"
  [star]
  (map #(orbital-period % (:mass star))))

(defn orbital-periods-transformations
  [planets star]
  (sequence (orbital-period-transformation star) planets))


(defn orbital-periods-transformations-vector
  [planets star]
  (into [] (orbital-period-transformation star) planets))

(defn orbital-periods-transformations-list
  [planets star]
  (into () (orbital-period-transformation star) planets))
