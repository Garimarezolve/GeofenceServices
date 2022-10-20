FROM openjdk:11
ADD target/geofenceService-0.0.1-SNAPSHOT.jar app_geo.jar
ENTRYPOINT ["java","-jar","/app_geo.jar"]