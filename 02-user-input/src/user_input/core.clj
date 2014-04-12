(ns user-input.core
  (:gen-class))

(defn -main [& args]
  (println "What's your name?")
  (printf "Hello %s, how's it going?\n" (read-line)))
  
