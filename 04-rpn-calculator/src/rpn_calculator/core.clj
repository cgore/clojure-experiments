(ns rpn-calculator.core
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
   (-> (frame :title "04: RPN Calculator"
              :content (button :text "Quit!"
                               :listen [:action (fn [e] (System/exit 0))])
              :on-close :exit)
       pack!
       show!)))
