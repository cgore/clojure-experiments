(ns gui-button.core
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
   (-> (frame :title "03: GUI Button"
              :content (button :text "Quit!")
              :on-close :exit)
       pack!
       show!)))
