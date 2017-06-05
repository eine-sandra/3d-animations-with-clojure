(ns noise-sphere.core
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))

(def screen-w 500)
(def screen-h 500)

(defn setup []
  {:x 0})

(defn my-noise []
  (noise 0.005 0.05 0.5))

(defn draw-sphere[x y]
  (push-matrix)
  (translate (* (my-noise) x) (* (my-noise) y) (rand-int 480))
  ;(translate x y (rand-int 230))
  ;(fill (cos-change))
  (sphere (* 20 (cos (/ (frame-count) 100.0))))
  (fill (random 180 250) (* 230 (cos (/ (frame-count) 100.0))) (* 500 (cos (/ (frame-count) 100.0))))
  ;(fill (rand 255) (rand 255) (rand 255))
  (pop-matrix))
  
  
  


(defn draw [old-state]
  (background (* (my-noise) 220))
  ;(fill (rand 255) (rand 255) (rand 255))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.9)
  (rotate-y (* (* 430 (cos (/ (frame-count) 100.0))) 0.0001))
  (rotate-x (* (* 280 (cos (/ (frame-count) 100.0))) 0.0001))
  (let [series (take 7 (iterate #(+ % (rand 190)) -250))]
    (doseq [x series
            y series]
           
      (draw-sphere x y))))
  

(defsketch example
  :title "Example"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  :renderer :p3d
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])

