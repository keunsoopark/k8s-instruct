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
