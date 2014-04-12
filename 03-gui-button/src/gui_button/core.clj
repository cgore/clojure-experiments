(ns gui-button.core
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
   (-> (frame :title "03: GUI Button",
              :content "GUIs are awesome",
              :on-close :exit)
       pack!
       show!)))
