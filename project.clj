(defproject wikimalea "0.1.0-alpha"
  :description "Search Engine for English Wikipedia, using Semantic Hashing"
  :url "https://github.com/dylon/wikimalea"
  :license {:name "The MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [korma "0.3.0-beta9"]
                 [postgresql "9.1-901.jdbc4"]
                 [log4j "1.2.15" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]])
