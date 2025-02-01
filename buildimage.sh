./gradlew bootBuildImage --builder ghcr.io/thomasvitale/java -builder-arm64


./gradlew bootBuildImage \
  --imageName ghcr.io/<your_github_username>/catalog-service \
  --publishImage \
  -PregistryUrl=ghcr.io \
  -PregistryUsername=<your_github_username> \
  -PregistryToken=<your_github_token>


docker image save -o image.tar  catalog-service:latest

minikube image load image.tar --profile polar

