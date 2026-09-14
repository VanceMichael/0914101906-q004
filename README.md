# 双人障碍赛配对检录服务

这是一个 Java 纯后端项目，演出行程数据使用本地 SQLite 文件保存，路径由 `ARTIST_TOUR_DB_PATH` 指定，未设置时使用 `artist-tour.db`。

数据库迁移：`./mvnw flyway:migrate`。启动：`./mvnw spring-boot:run`，健康检查为 `/health`。测试：`./mvnw test`。容器运行：`docker build -t artist-tour . && docker run --rm -p 8080:8080 artist-tour`。
