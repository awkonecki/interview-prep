# VOLUME /tmp
# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS
# ADD nebo-ws.jar nebo-ws.jar

# Base image
FROM ubuntu

# First set of utilies needed.
RUN apt-get update -y && apt-get install -y \
    apt-utils \
    debconf-utils \
    software-properties-common
# Setup of the repo to pull from the java repo called out from 
# [bazel](https://docs.bazel.build/versions/master/install-ubuntu.html) 
# install site.
RUN add-apt-repository ppa:webupd8team/java
# Dealing with the license agreement for oracle.
RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | debconf-set-selections
# Installation of desired packages.
RUN apt-get update -y && DEBIAN_FRONTEND=noninteractive apt-get install -y \
    curl \
    git \
    g++ \
    oracle-java8-installer \
    pkg-config \
    python \
    unzip \
    vim \
    zip \
    zlib1g-dev \
    && rm -fr /var/lib/ap/lists/*
# Handling blaze install from pub.
RUN echo "deb [arch=amd64] http://storage.googleapis.com/bazel-apt stable jdk1.8" | tee /etc/apt/sources.list.d/bazel.list
RUN curl https://bazel.build/bazel-release.pub.gpg | apt-key add -
RUN apt-get update -y && apt-get install -y bazel