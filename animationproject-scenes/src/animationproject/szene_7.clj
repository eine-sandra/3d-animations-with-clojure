(ns animationproject.szene-7
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))




(defn draw-box [x y]
  (push-matrix)
  (translate x y (* 230 (cos (/ (frame-count) 100.0))))
  ;(translate x y (rand-int 230))
  ;(fill (cos-change))
  (box 45 45 (* 360 (cos (/ (frame-count) 100.0))))
  (fill (* 230 (cos (/ (frame-count) 100.0))) (* 500 (cos (/ (frame-count) 100.0))) 200)
  ;(fill (rand 255) (rand 255) (rand 255))
  (pop-matrix))
  
  
  

(defn draw [old-state screen-w screen-h]
  (background 0)
  ;(fill (rand 255) (rand 255) (rand 255))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 #_(:x old-state)  250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  (rotate-y 2.25)
  (rotate-x -0.9)
  ;(rotate-y (* (frame-count) 0.01))
  ;(rotate-x (* (frame-count) 0.01))
  (doseq [x [-120 -60 0 60 120]
          y [-120 -60 0 60 120]]
    (draw-box x y)))
  
