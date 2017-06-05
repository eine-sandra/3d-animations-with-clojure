(ns animationproject.szene-4
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))




(defn draw-box [x y]
  (push-matrix)
  (translate x y (rand-int 80))
  (box 100 100 70)
  (pop-matrix))
  
  


(defn draw [old-state screen-w screen-h]
  (background 0)
  (fill (rand 255) (rand 255) (rand 255))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 #_(:x old-state)  250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.8)
  (rotate-y (* (frame-count) 0.01))
  (rotate-x (* (frame-count) 0.01))
  (doseq [x [-120 0 120]
          y [-120 0 120]]
    (draw-box x y)))