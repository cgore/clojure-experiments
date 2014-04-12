(ns rpn-calculator.core
  (:use seesaw.core))

(defn north-controls []
  (button :text "Quit!" :listen [:action (fn [e] (dispose! (all-frames)))]))

(defn rpn-stack-view []
  "MAIN GOES HERE")

(defn south-controls []
  "TODO")

(defn number-pad []
  (grid-panel :columns 4 :rows 4
              :items (mapv (fn [x] (button :text x))
                           ["7" "8" "9"   "/"
                            "4" "5" "6"   "*"
                            "1" "2" "3"   "-"
                            "0" "." "SPC" "+"])))

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
