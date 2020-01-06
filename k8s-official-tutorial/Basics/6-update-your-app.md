## Performing a rolling update

1. Update the version of the app  

\# List your deployments  
`kubectl get deployments`

\# List running Pods  
`kubectl get pods`

\# View the current image version of the app  
Check the version of image (v1) in Containers>kubernetes-bootcamp>Image  
`kubectl describe pods` 

\# Update the version of image to v2  
`kubectl set image deployments/kubernetes-bootcamp kubernetes-bootcamp=jocatalin/kubernetes-bootcamp:v2`

\# You can check the old Pods are terminated and new ones are started incrementally by AGE column.  
`kubectl get pods`

2. Verify an update  

\# Check the exposed IP address and port  
`kubectl describe services/kubernetes-bootcamp`

\# Create env var  
`export NODE_PORT=$(kubectl get services/kubernetes-bootcamp -o go-template='{{(index .spec.ports 0).nodePort}}')` 
`echo NODE_PORT=$NODE_PORT`

\# You can see v2 version of app is running with curl  
`curl $(minikube ip):$NODE_PORT`

\# Check rollout history
`kubectl rollout status deployments/kubernetes-bootcamp`

\# To view the current version of app  
`kubectl describe pods`

3. Rollback and update

\# Deploy v10 image  
`kubectl set image deployments/kubernetes-bootcamp kubernetes-bootcamp=gcr.io/google-samples/kubernetes-bootcamp:v10`

\# Rollback the image  
`kubectl rollout undo deployments/kubernetes-bootcamp`
