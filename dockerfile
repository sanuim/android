FROM ubuntu:22.04

RUN apt-get update
RUN apt-get install openjdk-8-jdk curl unzip zip gradle -y

ARG KOTLIN_VERSION=1.3.72

RUN cd /opt \
 && curl -LO https://github.com/JetBrains/kotlin/releases/download/v${KOTLIN_VERSION}/kotlin-compiler-${KOTLIN_VERSION}.zip \
 && unzip kotlin-compiler-${KOTLIN_VERSION}.zip \
 && rm kotlin-compiler-${KOTLIN_VERSION}.zip


# Add its directory to $PATH
ENV PATH=/opt/kotlinc/bin:$PATH

WORKDIR zad1

COPY . .

CMD ./gradlew build \
 && ./gradlew run \
 && echo "\n from gradle" \
 && cd app/src/main/java/zad1 \
 && javac -d . App.java \
 && java zad1.App \
 && echo " from cmd"



