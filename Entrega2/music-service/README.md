### Tutorial para rodar o Docker

```mvn package```
<br>

```sudo docker build -t user/music:1.0-SNAPSHOT .```
<br>

```sudo docker run -p 8100:8100 user/music:1.0-SNAPSHOT```
```sudo docker run -p 8761:8761 user/naming:1.0-SNAPSHOT```