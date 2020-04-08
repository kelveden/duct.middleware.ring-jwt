(defproject ovotech/duct.middleware.ring-jwt "1.0.0"
  :description "Integrant keys for ovotech/ring-jwt."
  :url "http://github.com/ovotech/duct.middleware.jwt"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[ovotech/ring-jwt "1.2.5"]]
  :profiles {:provided {:dependencies [[integrant "0.8.0"]
                                       [duct/core "0.8.0"]]}})
