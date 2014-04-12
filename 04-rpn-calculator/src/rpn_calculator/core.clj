(ns rpn-calculator.core
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
   (let [main-frame (frame :title "04: RPN Calculator"
                           :content (button :text "Quit!" :listen [:action (fn [e] (dispose! (all-frames)))])
                           :on-close :exit)]
     (-> main-frame pack! show!))))
