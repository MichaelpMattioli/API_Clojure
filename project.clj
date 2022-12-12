(defproject clojure_mysql "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/java.jdbc "0.7.9"]
                 [mysql/mysql-connector-java "8.0.21"]
                 [io.pedestal/pedestal.service"0.5.10"]
                 [io.pedestal/pedestal.service-tools "0.5.10"] ;; Only needed for ns-watching; WAR tooling
                 [io.pedestal/pedestal.jetty"0.5.10"]
                 [io.pedestal/pedestal.immutant"0.5.10"]
                 [io.pedestal/pedestal.tomcat"0.5.10"]
                 [io.pedestal/pedestal.aws"0.5.10"] ;; API-Gateway, Lambda, and X-Ray support
                 [io.pedestal/pedestal.route"0.5.10"]
                 [org.clojure/data.json"0.2.6"]
                 [org.slf4j/slf4j-simple"1.7.21"]]
  :main ^:skip-aot projeto.main
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:dependencies []
                   :source-paths ["dev"]}})