(ns gui-button.core
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
   (-> (frame :title "03: GUI Button"
              :content (button :text "Quit!"
                               :listen [:action (fn [e] (System/exit 0))])
              :on-close :exit)
       pack!
       show!)))
