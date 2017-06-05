(ns noise-try-one.core
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))


(def screen-w 500)
(def screen-h 500)

(defn setup []
  {:x 0})


(defn draw-box [x y z]
  (push-matrix)
  (translate (* (noise 0.005 0.05 0.5) x) (* (noise 0.005 0.05 0.5) y) (* (noise 0.005 0.05 0.5) z))
  (box (rand 25)(rand 25)(rand 25))
  (pop-matrix))
  
  


(defn draw [old-state]
  (background (* (noise 0.005 0.05 0.003) 220))
  (fill (* (noise 0.005 0.05 0.5) 255))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.8)
  (rotate-y (* (frame-count) 0.01))
  (rotate-x (* (frame-count) 0.01))
  (let [series (take 15 (iterate #(+ % 30) -250))]
    (doseq [x series
            y series
            z series]
      (draw-box x y z))))
    
  
  
  
 

(defsketch example
  :title "Example"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  :renderer :p3d
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])

