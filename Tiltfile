# How to build a container image (Cloud Native Buildpacks)
# Build
custom_build(
    # Name of the container image
    ref = 'catalog-service',
    # Command to build the container image
    command = './gradlew bootBuildImage --imageName $EXPECTED_REF',
    # Files to watch that trigger a new build
    deps = ['build.gradle', 'src']
)

# How to deploy the application (Kubernetes YAML manifests)
# Deploy
k8s_yaml(kustomize('k8s'))

# How to access the application (port forwarding)
# Manage
k8s_resource('catalog-service', port_forwards=['9001'])