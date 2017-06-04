(ns shapetry-five.core
 (:require [quil.core :refer :all]
           [quil.middleware :as m]))

(def screen-w 800)
(def screen-h 800)
      
      
(defn setup [])


(defn object [pos top bottom length]
  (with-translation [(/ screen-w 2) (/ screen-h 2) pos]

    
    (ellipse 0 0 top top)
    (doseq [i (range 0 (* (Math/PI) 2) 0.16)]
      ;(point (* (sin i) 145) (* (cos i) 145) 0)
      ;(point (* (sin i) 145) (* (cos i) 145) 200)
      
      (line (* (sin i) (/ top 2)) (* (cos i) (/ top 2)) 0
            (* (sin i) (/ bottom 2)) (* (cos i) (/ bottom 2)) length))
    
    (with-translation [0 0 length]
      (ellipse 0 0 bottom bottom))))



(defn tentacle [pos top bottom length]
  (with-translation [(/ screen-w 2) (/ screen-h 2) pos]

    
    (ellipse 0 0 top top)
    (doseq [i (range 0 (* (Math/PI) 2) 0.3)]
      ;(point (* (sin i) 145) (* (cos i) 145) 0)
      ;(point (* (sin i) 145) (* (cos i) 145) 200)
      
      (line (* (sin i) (/ top 2)) (* (cos i) (/ top 2)) 0
            (* (sin i) (/ bottom 2)) (* (cos i) (/ bottom 2)) length))))


(defn draw [old-state]
  (background 20 20 20)
  (no-fill)
  (stroke (* (noise 0.5 0.3 0.1) 230))
  (stroke-weight 2)
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (rotate-x -0.9)
 
  ;(rotate-y (* (frame-count) 0.01))
  ;(rotate-x (* (frame-count) 0.01))
  
  (object 0 80 (+ (* (sin (/ (frame-count) 20)) 10) 100) 50)
  (object 50 (+ (* (sin (/ (frame-count) 20)) 10) 100) 250 70)
  (object 120 250 (+ (* (sin (/ (frame-count) 20)) 10) 300) 60)
  (object 180 (+ (* (sin (/ (frame-count) 20)) 10) 300) 200 80)
  (object 260 200 (+ (* (sin (/ (frame-count) 20)) 10) 140) 120)
  (object 380 (+ (* (sin (/ (frame-count) 20)) 10) 140) 70 50)
  (object 430 70 (+ (* (sin (/ (frame-count) 20)) 10) 60) 110)
  
  (object 0 80 (+ (* (sin (/ (frame-count) 20)) 10) 80) 50)
  (object 50 (+ (* (sin (/ (frame-count) 20)) 10) 80) 200 70)
  (object 120 200 (+ (* (sin (/ (frame-count) 20)) 10) 250) 60)
  (object 180 (+ (* (sin (/ (frame-count) 20)) 10) 250) 160 80)
  (object 260 160 (+ (* (sin (/ (frame-count) 20)) 10) 100) 120)
  (object 380 (+ (* (sin (/ (frame-count) 20)) 10) 100) 50 50)
  (object 430 50 20 210)
  (tentacle 640 20 (+ (* (sin (/ (frame-count) 20)) 10) 40) (+ (* (cos (/ (frame-count) 20)) 50) 330)))
  

   


  ;(rotate-y (* (frame-count) 0.01))
  ;(rotate-x (* (frame-count) 0.01)))
 
  
 

(defsketch example
  :title "Example"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  :renderer :p3d
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])

