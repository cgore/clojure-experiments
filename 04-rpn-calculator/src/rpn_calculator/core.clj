(ns rpn-calculator.core
  (:use seesaw.core))

(def actions {:decimal  {:button-text "."}
              :0        {:button-text "0"}
              :1        {:button-text "1"}  
              :2        {:button-text "2"}
              :3        {:button-text "3"}
              :4        {:button-text "4"}
              :5        {:button-text "5"}
              :6        {:button-text "6"}
              :7        {:button-text "7"}
              :8        {:button-text "8"}
              :9        {:button-text "9"}
              :+        {:button-text "+"}
              :-        {:button-text "-"}
              :*        {:button-text "*"}
              :division {:button-text "/"}
              :quit     {:button-text "Quit"}
              :space    {:button-text "SPC"}})

(defn button-for-action [action]
  (->> (-> actions action :button-text)
       (button :text)))

(defn north-controls []
  (button :text "Quit!" :listen [:action (fn [e] (dispose! (all-frames)))]))

(defn rpn-stack-view []
  "MAIN GOES HERE")

(defn south-controls []
  "TODO")

(defn number-pad []
  (grid-panel :columns 4 :rows 4
              :items (mapv button-for-action
                           [:7 :8       :9     :division
                            :4 :5       :6     :*
                            :1 :2       :3     :-
                            :0 :decimal :space :+])))

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
