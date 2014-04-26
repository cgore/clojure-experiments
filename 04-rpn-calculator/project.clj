(defproject rpn-calculator "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/cgore/clojure-experiments"
  :license {:name "BSD 3-Clause"
            :url "https://github.com/cgore/clojure-experiments/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [seesaw "1.4.4"]]
  :main ^:skip-aot rpn-calculator.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
