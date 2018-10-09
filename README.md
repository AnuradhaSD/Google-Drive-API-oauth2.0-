# Google Drive API (oauth 2.0)

## Add Following Dependencies to pom.xml
```
<!-- https://mvnrepository.com/artifact/com.google.apis/google-api-services-drive -->

<dependency>
    <groupId>com.google.apis</groupId>
    <artifactId>google-api-services-drive</artifactId>
    <version>v3-rev105-1.23.0</version>
</dependency>

<!-- https://mvnrepository.com/artifact/com.google.api-client/google-api-client -->

<dependency>
    <groupId>com.google.api-client</groupId>
    <artifactId>google-api-client</artifactId>
    <version>1.23.0</version>
</dependency>
 
<!-- https://mvnrepository.com/artifact/com.google.oauth-client/google-oauth-client-jetty -->

<dependency>
    <groupId>com.google.oauth-client</groupId>
    <artifactId>google-oauth-client-jetty</artifactId>
    <version>1.23.0</version>
</dependency>
```

## Download and Installation

###### Clone the project to the local Machine

```
git clone https://github.com/AnuradhaSD/Google-Drive-API-oauth2.0-.git

```
### Run application

- Application Implemented Using Eclipse IDE
- Appache TomCat Should be Configured(Used Tomcat V7.0)

### Steps

#### 1.Create Credentials 
```
http://sanjeewafirst.blogspot.com/2018/10/create-credentials-google-drive-api.html

```
#### 2.Create credentials folder(Windows)
```
C:\Users\{user}\credentials

```
##### 3.Copy client_secret.json file to credentials folder 
##### 4.Run DriveApp.java as Java Application 
##### 5.Login with gamil account which have created the client_secret.json
##### 6.Credentials will download and store in PC
##### 7.Run Upload.java 
```
Run As -> Run On Server

```
##### 8.Browse and Upload text file
##### Click Upload

### Blog URL : [Google Drive API oauth Upload Files Java](http://sanjeewafirst.blogspot.com/2018/10/google-drive-api-oauth-20-upload-files.html)
