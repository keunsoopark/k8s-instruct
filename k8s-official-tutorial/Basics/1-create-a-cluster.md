## Using minikube to create a cluster  

### Cluster up and running

`minikube version`  

\# Running k8s cluster
\# Minikube starts a VM, and k8s cluster runs on that VM.  
`minikube start`  

### Cluster version

\# Check kubectl  
`kubectl version`  

### Cluster details

\# Check cluster status - master: It provides URL for cluster monitoring UI.  
`kubectl cluster-info`  

\# Check node status  
`kubectl get nodes`  
