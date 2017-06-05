(ns shape-two.core
 (:require [quil.core :refer :all]
           [quil.middleware :as m]))

(def screen-w 500)
(def screen-h 500)

(defn setup []
  {:x 0})


(defn pyramid [x y z]
  (push-matrix)
  (translate x y (* (cos (/ (frame-count) 100)) z))
  (begin-shape :triangles)
  
  (fill 0 255 255)
  (vertex -100 -100 -100)
  (fill 255 255 255)
  (vertex 100 -100 -100)
  (fill 0 255 0)
  (vertex 0 0 100)
  
  (fill 255 255 255)
  (vertex 100 -100 -100)
  (fill 255 255 0)
  (vertex 100 100 -100)
  (fill 0 0 255)
  (vertex 0 0 100)
  
  (fill 0 0 0)
  (vertex 100 100 -100)
  (fill 255 0 255)
  (vertex -100 100 -100)
  (fill 0 255 0)
  (vertex   0 0 100)
  
  (fill 0 255 0)
  (vertex -100 100 -100)
  (fill 0 0 255)
  (vertex -100 -100 -100)
  (fill 255 255 255)
  (vertex   0 0 100)
  (end-shape)
  (pop-matrix))
  
  
  


(defn draw [old-state]
  (background 20 20 20)
  ;(fill 255 255 255 50)
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.0)
  ;(rotate-x -0.9)
  (rotate-y (* (frame-count) 0.01))
  (rotate-x (* (frame-count) 0.01))
  (let [series (take 10 (iterate #(+ % 60) -10))]
    (doseq [x series
            y series
            z series]
      (pyramid x y z))))
 

(defsketch example
  :title "Example"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  :renderer :p3d
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])

