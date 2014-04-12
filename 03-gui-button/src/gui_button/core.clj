(ns gui-button.core
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
   (-> (frame :title "03: GUI Button"
              :content (button :text "Quit!"
                               :listen [:action (fn [e] (println "No!"))])
              :on-close :exit)
       pack!
       show!)))
