(ns noise-try-three.core
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))
            
           


(def screen-w 500)
(def screen-h 500)

(defn setup []
  {:x 0})

(defn my-noise []
  (noise 0.005 0.05 0.5))

(defn draw-box [x y z]
  (push-matrix)
  (translate (* (my-noise) x) (* (my-noise) y) (* (my-noise) z))
  (box (* 3 (cos (/ (frame-count) 100.0)))(* 3 (cos (/ (frame-count) 100.0)))(* 40 (cos (/ (frame-count) 100.0))))
  (pop-matrix))
  
  

(defn draw [old-state]
  (background (* (my-noise) 220))
  (fill (* (my-noise) 255))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (ambient-float 200) 
  (shininess 5.0)
  (translate (/ screen-w 2) (/ screen-h 2))
  ;(rotate-y 2.25)
  ;(rotate-x -0.8)
  (rotate-y (* (frame-count) 0.01))
  (rotate-x (* (frame-count) 0.01))
  (let [series (take 30 (iterate #(+ % (rand 40)) -250))]
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
