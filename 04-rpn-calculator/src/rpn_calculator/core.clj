(ns rpn-calculator.core
  (:use seesaw.core))

(defn north-controls []
  (button :text "Quit!" :listen [:action (fn [e] (dispose! (all-frames)))]))

(defn rpn-stack-view []
  (button :text "MAIN GOES HERE"))

(defn south-controls []
  (button :text "TODO"))

(defn number-pad []
  (grid-panel :columns 4 :rows 4
              :items ["7" (button "7") "8" (button "8") "9" (button "9") "/" (button "/")
                      "4" (button "4") "5" (button "5") "6" (button "6") "*" (button "*")
                      "1" (button "1") "2" (button "2") "3" (button "3") "-" (button "-")
                      "0" (button "0") "." (button ".") "," (button ",") "+" (button "+")]))

(defn -main [& args]
  (invoke-later
   (let [main-frame (frame :title "04: RPN Calculator"
                           :content (border-panel :north (north-controls)
                                                  :west (number-pad)
                                                  :center (rpn-stack-view)
                                                  :south (south-controls))
                           :on-close :exit)]
     (-> main-frame pack! show!))))
