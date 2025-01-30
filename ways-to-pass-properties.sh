# Configuring an application through command-line arguments
java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar --polar.greeting="Welcome to the catalog from CLI"

# Configuring an application through JVM system properties
java -Dpolar.greeting="Welcome to the catalog from JVM" -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar

#Configuring an application through environment variables
POLAR_GREETING="Welcome to the catalog from ENV" java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar
#On Windows, you can achieve the same result by running $env:POLAR_
#GREETING="Welcome to the catalog from ENV"; java -jar build/libs/
#catalog-service-0.0.1-SNAPSHOT.jar from a PowerShell console.

