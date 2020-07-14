# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  config.vm.define "neo4j" do |neo4j|
    neo4j.vm.box = "centos/7"

    neo4j.vm.provision "docker", images: ["bitnami/neo4j:latest"] do |d|
      d.run "bitnami/neo4j",
        args: "-p 7474:7474 -p 7473:7473 -p 7687:7687 --network=host -e NEO4J_PASSWORD=secret"
    end

    neo4j.vm.network "forwarded_port", guest: 7474, host: 7474
    neo4j.vm.network "forwarded_port", guest: 7473, host: 7473
    neo4j.vm.network "forwarded_port", guest: 7687, host: 7687
  end

  config.vm.define "kafka-and-zookeeper" do |knz|
    knz.vm.box = "centos/7"
    
    knz.vm.provision "docker", images: ["bitnami/zookeeper:latest", "bitnami/kafka:latest"] do |d|
      d.run "bitnami/zookeeper",
        args: "-p 2181:2181 -e ALLOW_ANONYMOUS_LOGIN=yes --network=host"

      d.run "bitnami/kafka",
        args: "--network=host -p 9092:9092 -p 29092:29092 -e KAFKA_CFG_ZOOKEEPER_CONNECT=0.0.0.0:2181 -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,PLAINTEXT_HOST://:29092 -e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092,PLAINTEXT_HOST://127.0.0.1:29092 -e KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT"
    end

    knz.vm.network "forwarded_port", guest: 9092, host: 9092
    knz.vm.network "forwarded_port", guest: 29092, host: 29092
    knz.vm.network "forwarded_port", guest: 2181, host: 2181
  end
end
