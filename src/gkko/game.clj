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
           ::markets {:us 0 :japan 1 :eu -4}

           ::events [{::event-type ::inc
                      ::name "Company 1"
                      ::inc 10}]})

(def market-symbol? #{:us :japan :eu})
(def market-change? (into #{} (range -1 2)))
(def market-value? (into #{} (range -5 6)))

(s/def ::market-symbol market-symbol?)
(s/def ::market-change market-change?)
(s/def ::market-value market-value?)
(s/def ::event (s/keys :req [::market ::market-change]))
(s/def ::game (s/keys :req [:markets]))

(s/fdef handle-event)

(defprotocol Event (handle-event [this game]))

(defrecord MarketEvent [market change]
  Event
  (handle-event [this game]
    (let [v (-> game ::markets market)]
      (assoc-in game
                [::markets market]
                (+ v (:change this))))))

(s/valid? ::companies (::companies game))


(gen/generate (s/gen ::event))






