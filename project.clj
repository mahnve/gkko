(defproject gkko "0.1.0-SNAPSHOT"
  :description "Venture capitalist game"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [http-kit "2.1.16"]
                 [reagent "0.4.3"]
                 [com.taoensso/sente "1.2.0"]
                 [compojure "1.2.1"]]
  :ring {:handler gkko.handler/app}
  :plugins [[lein-cljsbuild "1.0.3"]])
