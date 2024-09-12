A node is a machine, physical or virtual, on which Kubernetes is installed.

A node is a worker machine and that is where containers  will be launched by Kubernetes.

A cluster is a set of nodes grouped together. This way,  even if one node fails, you have your application still accessible from the other nodes. Moreover, having multiple nodes


The master is another node with Kubernetes installed in it,
 -  is responsible for managing the cluster?
 - information about members of the cluster stored
 - How are the nodes monitored?
 - When a node fails, move the workload of the failed node to another worker node
 - The master watches over the nodes in the cluster and is responsible for the actual orchestration of containers on the worker nodes.



When you install Kubernetes on a system, you are actually installing the following components;
 - API server => The API server acts as the front end for Kubernetes. The users, management devices, command-line interfaces, all talk to the API server to interact with the Kubernetes cluster.
 - etcd service
 - kubelet service, 
 - container runtime, 
 - controllers, and 
 - schedulers.



kubectl run nginx --image nginx

kubectl create -f pod-definition.yml
kubectl get pods
kubectl delete pod <pod-name>
kubectl delete pod <pod-name> --force

kubectl create -f replicaset-definition.yml
kubectl replace -f replicaset-definition.yml
kubectl scale --replicas=6 replicaset <name-of-replicaset>
kubectl scale --replicas=6 -f replicaset-definition.yml

kubectl get replicaset

kubectl get all

kubectl get pods --namespace=dev4

kubectl get pods --all-namespaces
kubectl get pods --selector app=tenant-server,pod-template-hash=569dd6f45b

kubectl edit replicaset  <name-of-replicaset>
kubectl rollout history deployment.apps/<name-of-deployment>
kubectl rollout undo deployment/<name-of-deployment>

kubectl get secret app-secret –o yaml
kubectl get secret aisera-airflow2x -o jsonpath="{.data.airflow-password}" | base64 --decode
kubectl get secret redis  -o jsonpath="{.data.redis-password}" | base64 --decode
kubectl get secret redis -o jsonpath='{.data}'

kubectl get endpoints

kubectl top node
kubectl top pod
