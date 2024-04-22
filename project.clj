(defproject net.clojars.kelveden/duct.middleware.ring-jwt "2.8.1"
  :description "Integrant keys for kelveden/ring-jwt."
  :url "http://github.com/kelveden/duct.middleware.jwt"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[net.clojars.kelveden/ring-jwt "2.8.1"]]
  :profiles {:provided {:dependencies [[integrant "0.8.0"]
                                       [duct/core "0.8.0"]]}})
