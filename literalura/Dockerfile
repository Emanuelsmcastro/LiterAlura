FROM maven:3.8.1-openjdk-17
WORKDIR /project
COPY target/literalura-0.0.1-SNAPSHOT.jar /project/app.jar
RUN git clone https://github.com/Emanuelsmcastro/CurrencyConverter.git
WORKDIR /project/CurrencyConverter/currency_converter
RUN mvn clean install
WORKDIR /project
ENTRYPOINT [ "java", "-jar", "app.jar" ]