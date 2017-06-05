(ns animationproject.szene-8
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))


(defn draw-box [x y]
  (push-matrix)
  (translate x y (* 400 (cos (/ (frame-count) 100.0))))
  ;(translate x y (rand-int 230))
  ;(fill (cos-change))
  (box 45 45 (* 800 (cos (/ (frame-count) 100.0))))
  (fill 250 (* 230 (cos (/ (frame-count) 100.0))) (* 500 (cos (/ (frame-count) 100.0))))
  ;(fill (rand 255) (rand 255) (rand 255))
  (pop-matrix))
  
  
  


(defn draw [old-state screen-w screen-h]
  (background 0)
  ;(fill (rand 255) (rand 255) (rand 255))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.9)
  (rotate-y (* (frame-count) 0.01))
  (rotate-x (* (frame-count) 0.01))
  (doseq [x [(* 1 (cos (/ (frame-count) 100.0))) (* 200 (cos (/ (frame-count) 100.0))) (* 400 (cos (/ (frame-count) 100.0))) (* 600 (cos (/ (frame-count) 100.0)))]
          y [(* 1 (cos (/ (frame-count) 100.0))) (* 200 (cos (/ (frame-count) 100.0))) (* 400 (cos (/ (frame-count) 100.0))) (* 600 (cos (/ (frame-count) 100.0)))]]
    (draw-box x y)))