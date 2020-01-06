## Use a service to expose your app

\# List Services from the cluster  
`kubectl get services`

\# Create new service (with `NodePort` as an option) and expose it to external traffic.  
\# `kubernetes-bootcamp` is the name of new service.  
`kubectl expose deployment/kubernetes-bootcamp --type="NodePort" --port 8080`

\# To check what port is opened externally  
`kubectl describe services/kubernetes-bootcamp`

\# Create env var for Node port assigned  
`export NODE_PORT=$(kubectl get services/kubernetes-bootcamp -o go-template='{{(index .spec.ports 0).nodePort}}')`  
`echo NODE_PORT=$NODE_PORT`

\# To check if the app is externally exposed.
`curl $(minikube ip):$NODE_PORT`

\# To see the name of label for the Pod.  
(label has been automatically assigned by Deployment.)  
`kubectl describe deployment`

\# To query the list of Pods using the label  
(`run=kubernetes-bootcamp` is the label of the Pod.)  
`kubectl get pods -l run=kubernetes-bootcamp`

\# To query the list of Service using the label  
`kubectl get services -l run=kubernetes-bootcamp`

\# Create env var for Pod name  
`export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')`  
`echo Name of the Pod: $POD_NAME`

\# Apply new label to the Pod (with pinning the application version to the Pod.)  
`kubectl label pod $POD_NAME app=v1`

\# To check the changes for new label  
`kubectl describe pods $POD_NAME`

\# To see the new label is attached to the Pod.  
`kubectl get pods -l app=v1`

\# Delete service  
`kubectl delete service -l run=kubernetes-bootcamp`

\# To see if the service is deleted.  
`kubectl get services`

\# To see if the external IP is not available because the service is deleted.  
`curl $(minikube ip):$NODE_PORT`

\# But the app is still running. You can check this by running curl inside the Pod.  
`kubectl exec -ti $POD_NAME curl localhost:8080`  