(ns animationproject.szene-5
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))


(defn draw [old-state screen-w screen-h]
  (background 0)
  (point-light 200 10 10
               10 200 200)
  (ambient-light 240 200 10)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.8)
  (rotate-y (* (frame-count) 0.01))
  (rotate-x (* (frame-count) 0.01))
  (sphere (* 150 (cos (/ (frame-count) 100.0)))))