(ns shapetryseven.core
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))

(def screen-w 800)
(def screen-h 800)
      
      
(defn setup [])

;(defn my-sphere [pos res]
;   (with-translation [(/ screen-w 2) (/ screen-h 2) pos]
;     (sphere-detail 0)
;     (sphere 150))


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
    (doseq [i (range 0 (* (Math/PI) 2) 0.16)]
      ;(point (* (sin i) 145) (* (cos i) 145) 0)
      ;(point (* (sin i) 145) (* (cos i) 145) 200)
      
      (line (* (sin i) (/ top 2)) (* (cos i) (/ top 2)) 0
            (* (sin i) (/ bottom 2)) (* (cos i) (/ bottom 2)) length))))





(defn draw [old-state]
  (background 20 20 20)
  (no-fill)
  (stroke (* (noise 0.5 0.3 0.3) 230))
  (stroke-weight (* (noise 0.5 0.3 0.3) 2.5))
  (point-light 200 10 10
               200 200 200)
  (ambient-light 240 250 210)
  (rotate-x -0.9)
 
  ;(rotate-y (* (frame-count) 0.01))
  ;(rotate-x (* (frame-count) 0.01))
  
  
  (tentacle 0 (+ (* (sin (/ (frame-count) 20)) 10) 40) (+ (* (sin (/ (frame-count) 20)) 20) 80) (+ (* (cos (/ (frame-count) 20)) 60) -150))
  (object 0 (+ (* (sin (/ (frame-count) 20)) 10) 40) 200 30)
  (object 30 200 (+ (* (sin (/ (frame-count) 20)) 10) 300) 30)
  (object 60 (+ (* (sin (/ (frame-count) 20)) 10) 300) 400 30)
  (object 90 400 (+ (* (sin (/ (frame-count) 20)) 10) 480) 30)
  (object 120 (+ (* (sin (/ (frame-count) 20)) 10) 480) 520 30)
  (object 150 520 (+ (* (sin (/ (frame-count) 20)) 10) 500) 30)
  (object 180 (+ (* (sin (/ (frame-count) 20)) 10) 500) 460 30)
  (object 210 460 (+ (* (sin (/ (frame-count) 20)) 10) 420) 30)
  (object 240 (+ (* (sin (/ (frame-count) 20)) 10) 420) 300 30)
  (object 270 300 300 100)
  
  
  (object 370 (+ (* (sin (/ (frame-count) 20)) 10) 300) 420 30)
  (object 400 420 (+ (* (sin (/ (frame-count) 20)) 10) 460) 30)
  (object 430 (+ (* (sin (/ (frame-count) 20)) 10) 460) 500 30)
  (object 460 500 (+ (* (sin (/ (frame-count) 20)) 10) 520) 30)
  (object 490 (+ (* (sin (/ (frame-count) 20)) 10) 520) 480 30)
  (object 520 480 (+ (* (sin (/ (frame-count) 20)) 10) 400) 30)
  (object 550 (+ (* (sin (/ (frame-count) 20)) 10) 400) 300 30)
  (object 580 300 (+ (* (sin (/ (frame-count) 20)) 10) 200) 30)
  (object 610 200 (+ (* (sin (/ (frame-count) 20)) 10) 40) 30)
  (tentacle 640 (+ (* (sin (/ (frame-count) 20)) 10) 40) (+ (* (sin (/ (frame-count) 20)) 20) 80) (+ (* (cos (/ (frame-count) 20)) 60) 150))
  
  
  (object 30 20 (+ (* (sin (/ (frame-count) 40)) 10) 200) 30)
  (object 60 (+ (* (sin (/ (frame-count) 40)) 10) 200) 300 30)
  (object 90 300 (+ (* (sin (/ (frame-count) 40)) 10) 380) 30)
  (object 120 (+ (* (sin (/ (frame-count) 40)) 10) 380) 420 30)
  (object 150 420 (+ (* (sin (/ (frame-count) 40)) 10) 400) 30)
  (object 180 (+ (* (sin (/ (frame-count) 40)) 10) 400) 360 30)
  (object 210 360 (+ (* (sin (/ (frame-count) 40)) 10) 320) 30)
  (object 240 (+ (* (sin (/ (frame-count) 40)) 10) 360) 240 30)
  (object 270 240 240 100)
  
  
  (object 370 (+ (* (sin (/ (frame-count) 40)) 10) 240) 320 30)
  (object 400 320 (+ (* (sin (/ (frame-count) 40)) 10) 360) 30)
  (object 430 (+ (* (sin (/ (frame-count) 40)) 10) 360) 400 30)
  (object 460 400 (+ (* (sin (/ (frame-count) 40)) 10) 420) 30)
  (object 490 (+ (* (sin (/ (frame-count) 40)) 10) 420) 380 30)
  (object 520 380 (+ (* (sin (/ (frame-count) 40)) 10) 300) 30)
  (object 550 (+ (* (sin (/ (frame-count) 40)) 10) 300) 200 30)
  (object 580 200 (+ (* (sin (/ (frame-count) 40)) 10) 20) 30))
 
   
    
 

(defsketch example
  :title "Example"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  :renderer :p3d
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])

