package com.mars.awsrds.configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rds.RdsUtilities;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
public class DataSourceConfig {

   // @Bean
    public DataSource dataSource() {
        String region = "us-east-1"; // Replace with your AWS region
        String dbEndpoint = "database-1.cnffqhpxhtmx.us-east-1.rds.amazonaws.com"; // Replace with your Aurora endpoint
        String dbUsername = "iam_user";

        int port = 5432; // PostgreSQL default port
        String database = "booksdb"; // Replace with your database name

        // Generate the IAM authentication token
        String iamAuthToken = RdsUtilities.builder()
                .region(Region.of(region))
                .build()
                .generateAuthenticationToken(r -> r
                        .hostname(dbEndpoint)
                        .port(port)
                        .username(dbUsername)
                );

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(String.format("jdbc:postgresql://%s:%d/%s", dbEndpoint, port, database));
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(iamAuthToken);

//        PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setUrl("jdbc:postgresql://" + dbEndpoint + ":5432/"+database);
//        dataSource.setUser(dbUsername);
//        dataSource.setPassword(iamAuthToken);

        // Additional properties for PostgreSQL SSL and IAM
        Properties props = new Properties();
        props.setProperty("ssl", "true");
        props.setProperty("sslmode", "verify-full");
        props.setProperty("sslrootcert", "us-east-1-bundle.pem"); // Ensure this cert is in your classpath
        dataSource.setConnectionProperties(props);

        return dataSource;
        //return null;
    }
}
