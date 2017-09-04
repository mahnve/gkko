(ns gkko.game
  (:require [clojure.spec.alpha :as s]
            [clojure.test.check :as t]
            [clojure.spec.gen.alpha :as gen]))

(s/def ::name string?) 
(s/def ::initial-value pos-int?)
(s/def ::company (s/keys :req [::name ::initial-value]))
(s/def ::companies (s/coll-of ::company))
(s/def ::game ())
(s/def ::event-type keyword?)

(defrecord Company [name initial-value])

(def game {::companies [{::name "Company 1"
                         ::initial-value 10}
                        {::name "Company 2"
                         ::initial-value 20}]
           ::events [{::event-type ::inc
                      ::name "Company 1"
                      ::inc 10}]})

(defmulti handle-event ::event-type)
(defmethod handle-event ::inc [_] (s/keys :req [::event-type ::]))


(s/valid? ::companies (::companies game))


(gen/generate (s/gen ::company))






