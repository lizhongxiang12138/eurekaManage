FROM java
MAINTAINER lzx <953934680@qq.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/eurekaManage/eurekaManage.jar"]

ARG JAR_FILE
ADD target/eurekaManage-0.0.1-SNAPSHOT.jar /usr/share/eurekaManage/eurekaManage.jar