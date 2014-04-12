(ns gui-button.core
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
   (-> (frame :title "03: GUI Button"
              :content (let [quit-button (button :text "Quit!")]
                         (listen quit-button
                                 :action (fn [e] (println "No!")))
                         quit-button)
              :on-close :exit)
       pack!
       show!)))
