## Vewing pods and nodes

\# To look the existing pods  
`kubectl get pods`

\# To view all information about pods, including what containers are inside, storage, network etc.  
`kubectl describe pods`

(Use proxy to debug Pods since they are running in an isolated, private network.)  

\# Get Pod names:  
`export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')`

\# To see the output of the application (The url is the route to the API of the Pod).  
`curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME/proxy/`  

 \# To see logs on application (container), which is stored in `STDOUT`  
`kubectl logs $POD_NAME`

We can use `excu` command to execute a command on a container in a pod.

\# To list the environmental variables in a pod  
`kubectl exec $POD_NAME env`

\# To start a bash session in Pod's container
\# You will get an open console on the container where NodeJS application is running.  
`kubectl exec -ti $POD_NAME bash`

\# To see the source code in the container  
`cat server.js`

\# To check that the application is up and running  
`curl localhost:8080`

\# To close the container connection  
`exit`