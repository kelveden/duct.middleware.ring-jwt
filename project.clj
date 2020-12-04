(defproject ovotech/duct.middleware.ring-jwt "2.0.2"
  :description "Integrant keys for ovotech/ring-jwt."
  :url "http://github.com/ovotech/duct.middleware.jwt"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[ovotech/ring-jwt "2.0.2"]]
  :profiles {:provided {:dependencies [[integrant "0.8.0"]
                                       [duct/core "0.8.0"]]}})
