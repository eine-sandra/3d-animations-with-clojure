(ns animationproject.szene-6
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))


(defn draw-box [x y]
  (push-matrix)
  (translate x y (rand-int 230))
  ;(fill (cos-change))
  (box 45 45 360)
  (fill (rand 255) (rand 255) (rand 255))
  (pop-matrix))
  
 

(defn draw [old-state screen-w screen-h]
  (background 0)
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 #_(:x old-state)  250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  (rotate-y 2.25)
  (rotate-x -0.8)
  ;(rotate-y (* (frame-count) 0.01))
  ;(rotate-x (* (frame-count) 0.01))
  (doseq [x [-100 -50 0 50 100]
          y [-100 -50 0 50 100]]
    (draw-box x y)))