## Using kubectl to create a deployment

\# Deploy app on k8s - need to provide the deployment name and the location of image in Docker hub.
`kubectl create deployment kubernetes-bootcamp --image=gcr.io/google-samples/kubernetes-bootcamp:v1`

\# List your deployments  
`kubectl get deployments`

\# Open proxy for connection between the host (= your terminal) and the k8s cluster.  
`kubectl proxy`

### In order for the new deployement to be accessible without using the proxy, a Service is required.

\# All k8s APIs are hosted through the proxy, which means `kubectl version` is identical with  
`curl http://localhost:8001/version`

\# Store pod names as environmental variable.  
`export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')`  
`echo Name of the Pod: $POD_NAME`
