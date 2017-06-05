(ns animationproject.core
  (:require [quil.core :refer :all]
            [quil.middleware :as m]
            [animationproject.szene-1 :as szene-1]
            [animationproject.szene-2 :as szene-2]
            [animationproject.szene-3 :as szene-3]
            [animationproject.szene-4 :as szene-4]
            [animationproject.szene-5 :as szene-5]
            [animationproject.szene-6 :as szene-6]
            [animationproject.szene-7 :as szene-7]
            [animationproject.szene-8 :as szene-8]))


(def screen-w 500)
(def screen-h 500)

(defn setup []
  {:x 0
   :szene 0})


(defn draw [old-state]
  (let [szene-fns [szene-1/draw szene-2/draw szene-3/draw szene-4/draw szene-5/draw szene-6/draw szene-7/draw szene-8/draw]
        szene-fn (nth szene-fns (:szene old-state))]
    (szene-fn old-state screen-w screen-h)(println "fc " (frame-count))))
  
  
  
(defn update-state [old-state]
  (cond
    (< (mod (frame-count) 4800) 600) (assoc old-state :szene 0)
    (< (mod (frame-count) 4800) 1200) (assoc old-state :szene 1)
    (< (mod (frame-count) 4800) 1800) (assoc old-state :szene 2)
    (< (mod (frame-count) 4800) 2400) (assoc old-state :szene 3)
    (< (mod (frame-count) 4800) 3000) (assoc old-state :szene 4)
    (< (mod (frame-count) 4800) 3600) (assoc old-state :szene 5)
    (< (mod (frame-count) 4800) 4200) (assoc old-state :szene 6)
    (< (mod (frame-count) 4800) 4800) (assoc old-state :szene 7)))
      
      
  


(defsketch example
  :title "Example"
  :setup setup
  :draw draw
  :update update-state
  :size [screen-w screen-h]
  :renderer :p3d
  :middleware [m/fun-mode m/navigation-3d])

(defn -main [& args])

