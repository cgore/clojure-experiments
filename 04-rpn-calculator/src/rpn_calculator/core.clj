(ns rpn-calculator.core
  (:require [clojure.string :as string])
  (:use seesaw.core))

(let [stack (ref [])
      working (ref [])]
  (defn add-digit [digit]
    (dosync (alter working conj digit))))

(def actions {:decimal        {:text "."
                               :action (fn [e] (add-digit "."))}
              :0              {:text "0"
                               :action (fn [e] (add-digit 0))}
              :1              {:text "1"
                               :action (fn [e] (add-digit 1))}
              :2              {:text "2"
                               :action (fn [e] (add-digit 2))}
              :3              {:text "3"
                               :action (fn [e] (add-digit 3))}
              :4              {:text "4"
                               :action (fn [e] (add-digit 4))}
              :5              {:text "5"
                               :action (fn [e] (add-digit 5))}
              :6              {:text "6"
                               :action (fn [e] (add-digit 6))}
              :7              {:text "7"
                               :action (fn [e] (add-digit 7))}
              :8              {:text "8"
                               :action (fn [e] (add-digit 8))}
              :9              {:text "9"
                               :action (fn [e] (add-digit 9))}
              :addition       {:text "+"
                               :action (fn [e])}
              :subtraction    {:text "-"
                               :action (fn [e])}
              :multiplication {:text "*"
                               :action (fn [e])}
              :division       {:text "/"
                               :action (fn [e])}
              :quit           {:text "Quit"
                               :action (fn [e] (dispose! (all-frames)))}
              :space          {:text "SPC"
                               :action (fn [e])}})

(defn button-for-action [action-key]
  (let [action (action-key actions)]
    (button :text (:text action)
            :listen [:action (:action action)])))

(defn north-controls []
  (button-for-action :quit))

(defn rpn-stack-view []
  "MAIN GOES HERE")

(defn south-controls []
  "TODO")

(defn number-pad []
  (grid-panel :columns 4 :rows 4
              :items (mapv button-for-action
                           [:7 :8       :9     :division
                            :4 :5       :6     :multiplication
                            :1 :2       :3     :subtraction
                            :0 :decimal :space :addition])))

(defn -main [& args]
  (invoke-later
   (let [main-frame (frame :title "04: RPN Calculator"
                           :content (border-panel :north (north-controls)
                                                  :west (number-pad)
                                                  :center (rpn-stack-view)
                                                  ;:south (south-controls)
                                                  )
                           :on-close :exit)]
     (-> main-frame pack! show!))))
