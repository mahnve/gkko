(defproject gkko "0.1.0-SNAPSHOT"
  :description "Venture capitalist game"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha19"]
                 [org.clojure/core.async "0.3.443"]
                 [org.clojure/test.check "0.10.0-alpha2"]]
  
  :main ^:skip-aot gkko.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
