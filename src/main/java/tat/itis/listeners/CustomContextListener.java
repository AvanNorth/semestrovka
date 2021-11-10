package tat.itis.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import tat.itis.dao.FilesRepository;
import tat.itis.dao.LabsRepository;
import tat.itis.dao.UsersRepository;
import tat.itis.dao.impl.FilesRepositoryImpl;
import tat.itis.dao.impl.LabsRepositoryImpl;
import tat.itis.dao.impl.UsersRepositoryImpl;
import tat.itis.services.FileService;
import tat.itis.services.PasswordEncoder;
import tat.itis.services.SignInService;
import tat.itis.services.SignUpService;
import tat.itis.services.impl.*;
import tat.itis.services.validation.Validator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebListener
public class CustomContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String DB_USERNAME;
        String DB_PASSWORD;
        String DB_URL;
        String DB_DRIVER;
        String JWT_SECRET;
        String IMAGES_STORAGE_PATH;
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Требуется файл properties");
        }
        DB_USERNAME = (String) properties.get("spring.datasource.username");
        DB_PASSWORD = (String) properties.get("spring.datasource.password");
        DB_URL = (String) properties.get("spring.datasource.url");
        DB_DRIVER = (String) properties.get("spring.datasource.driver-class-name");
        JWT_SECRET = (String) properties.get("jwt.secret");
        IMAGES_STORAGE_PATH = (String) properties.get("storage.images");

        ServletContext servletContext = servletContextEvent.getServletContext();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);

        FilesRepository fileRepository = new FilesRepositoryImpl(dataSource);
        UsersRepository usersRepository = new UsersRepositoryImpl(dataSource);
        LabsRepository labsRepository = new LabsRepositoryImpl(dataSource);
        FileService filesService = new FileServiceImpl(IMAGES_STORAGE_PATH, fileRepository, labsRepository, usersRepository);
        PasswordEncoder passwordEncoder = new PasswordEncoderImpl();
        SignInService signInService = new SignInServiceImpl(JWT_SECRET, usersRepository, labsRepository, passwordEncoder);
        Validator validator = new ValidatorImpl(usersRepository, labsRepository);
        SignUpService signUpService = new SignUpServiceImpl(usersRepository, labsRepository, passwordEncoder, validator);
        //PostsRepository postsRepository = new PostsRepositoryImpl(dataSource);
        //PostsService postsService = new PostsServiceImpl(postsRepository);
        //ObjectMapper objectMapper = new ObjectMapper();

       servletContext.setAttribute("filesService", filesService);
        servletContext.setAttribute("signInService", signInService);
        servletContext.setAttribute("signUpService", signUpService);
       // servletContext.setAttribute("postsService", postsService);
        servletContext.setAttribute("passwordEncoder", passwordEncoder);
        //servletContext.setAttribute("objectMapper", objectMapper);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}