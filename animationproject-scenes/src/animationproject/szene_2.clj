(ns animationproject.szene-2
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))

(defn draw-box [x y z]
  (push-matrix)
  (translate x y z)
  ;(fill (cos-change))
  (box (rand 30) (rand 30) (rand 30))
  (pop-matrix))
  
  


(defn draw [old-state screen-w screen-h]
  (background 0)
  (fill (* (noise 0.005 0.05 0.5) 255))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.8)
  (rotate-y (* (frame-count) 0.01))
  (rotate-x (* (frame-count) 0.01))
  (let [series (take 20 (iterate #(+ % 30) -200))]
    (doseq [x series
            y series
            z series]
      (draw-box x y z))))
    
  
  