# Используем официальный образ OpenJDK
FROM amazoncorretto:21.0.2

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл приложения в контейнер
COPY target/aws-loading-demo     /app/app.jar

# Указываем порт, который будет использоваться приложением
EXPOSE 8080

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]