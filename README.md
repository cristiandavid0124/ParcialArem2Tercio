## Parcial 2do Tercio - Arep


## Iniciar Proyecto

para ejecutar el proyectoo siga los siguientes pasos 

primero clone el repositorio 

https://github.com/cristiandavid0124/ParcialArem2Tercio.git

el repositorio cuenta con 3 microservicios uno en el que esta binary search  otro en el que esta linearSearch y en otro el que esta el index.html  y el proxy 
tiene que estar corriendo los 3 en diferentes terminales  y entrar al localhost:8080

para ejecutar el microservicio de  binarysearch

cd ParcialArem2Tercio 
cd microservice1
y ejecutar 

mvn exec:java -D"exec.mainClass=com.edu.eci.MathService1Application"      

para ejecutar el microservicio de  proxy y html 

cd microservice2

mvn exec:java -D"exec.mainClass=com.edu.eci.ProxyServerApplication"

cd microservice3

mvn exec:java -D"exec.mainClass=com.edu.eci.MathService2Application"

luego entra a localHost:8080 y podra hacer sus pruebas




linearSearch

![image](https://github.com/user-attachments/assets/eec39e48-1b1e-4515-a3e2-4b2fc51404c6)


![image](https://github.com/user-attachments/assets/d6199985-8419-4436-a482-beedeb29dfd5)


binary search


![image](https://github.com/user-attachments/assets/9ae88b5b-4d01-4881-bf3c-cb91b50d6297)




Proceso en la nube 

![image](https://github.com/user-attachments/assets/caee1acd-ce27-4607-9b12-9f1da3774c3f)



![image](https://github.com/user-attachments/assets/352375c6-c329-46c2-9878-03e2cf90f6d6)


instale java y maven en ambas maquinas 

![image](https://github.com/user-attachments/assets/e9f6c1e9-019a-42b8-8713-4ee1d2d4e5e1)

![image](https://github.com/user-attachments/assets/56621cc1-a266-444c-bc72-446551276f97)
me falto crear la ultima instancia 


