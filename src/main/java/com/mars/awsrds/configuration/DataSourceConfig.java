package com.mars.awsrds.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rds.RdsUtilities;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
public class DataSourceConfig {

   // @Bean
    public DataSource dataSource() {
        String region = "us-east-1"; // Replace with your AWS region
        String dbEndpoint = "<aurora-cluster-endpoint>"; // Replace with your Aurora endpoint
        String dbUsername = "<database-username>"; // Replace with your database username
        int port = 5432; // PostgreSQL default port
        String database = "<database-name>"; // Replace with your database name

        // Generate the IAM authentication token
        String iamAuthToken = RdsUtilities.builder()
                .region(Region.of(region))
                .build()
                .generateAuthenticationToken(r -> r
                        .hostname(dbEndpoint)
                        .port(port)
                        .username(dbUsername)
                );

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl(String.format("jdbc:postgresql://%s:%d/%s", dbEndpoint, port, database));
//        dataSource.setUsername(dbUsername);
//        dataSource.setPassword(iamAuthToken);
//
//        // Additional properties for PostgreSQL SSL and IAM
//        Properties props = new Properties();
//        props.setProperty("ssl", "true");
//        props.setProperty("sslmode", "verify-full");
//        props.setProperty("sslrootcert", "rds-ca-2019-root.pem"); // Ensure this cert is in your classpath
//        dataSource.setConnectionProperties(props);
//
//        return dataSource;
        return null;
    }
}
