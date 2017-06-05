(ns animationproject.szene-3
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))



(defn draw-box [x y z]
  (push-matrix)
  (translate x y z #_(rand-int 80))
  (box  20 20 20)
  (pop-matrix))
  
  


(defn draw [old-state screen-w screen-h]
  (background 0)
  (fill 255 (rand 255) ( rand 255))
  (point-light 200 200 200
               250 250 300)
  (point-light 200 200 200
               -250 -250 -300)
  ;(ambient-light 300 #_(:x old-state)  250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.8)
  (rotate-y (* (frame-count) 0.001))
  (rotate-x (* (frame-count) 0.01))
  (doseq [x [-250 -200 -150 -100 -50 0 50 100 150 200 250]
          y [-250 -200 -150 -100 -50 0 50 100 150 200 250]
          z [-250 -200 -150 -100 -50 0 50 100 150 200 250]]
    (draw-box x y z)))
  
  