# 双人障碍赛配对检录服务

这是一个 Java 纯后端项目，选手和检录状态使用本地 SQLite 保存，路径由 `OBSTACLE_CHECKIN_DB_PATH` 指定。

数据库迁移：`./mvnw flyway:migrate`。启动：`./mvnw spring-boot:run`，健康检查为 `/health`。测试：`./mvnw test`。容器运行：`docker build -t obstacle-checkin . && docker run --rm -p 8080:8080 obstacle-checkin`。
