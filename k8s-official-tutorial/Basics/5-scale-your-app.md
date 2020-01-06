## Running Multiple Instances of Your App

\# List your deployments  
`kubectl get deployments`
- READY = CURRENT / DESIRED  
  - CURRENT: # of replicas running now  
  - DESIRED: the configured number of replicas  
- UP-TO-DATE: # of replicas that were updated to match the configured state  
- AVAILABLE: # of available replicas to user  

\# Scale up with 4 replicas  
`kubernetes-bootcamp` is NAME of Deployment  
`kubectl scale deployments/kubernetes-bootcamp --replicas=4`

\# To check the status of new Pods  
`kubectl get pods -o wide`

\# To check the changes in the event log  
`kubectl describe deployments/kubernetes-bootcamp`

\# Find out the exposed IP and port of service  
`kubectl describe services/kubernetes-bootcamp`

\# You can check that your requests are handled by different Pods by executing `curl` multiple times  
`export NODE_PORT=$(kubectl get services/kubernetes-bootcamp -o go-template='{{(index .spec.ports 0).nodePort}}')`  
`echo NODE_PORT=$NODE_PORT`  
`curl $(minikube ip):$NODE_PORT`

\# Scale down to 2 replicas  
`kubectl scale deployments/kubernetes-bootcamp --replicas=2`