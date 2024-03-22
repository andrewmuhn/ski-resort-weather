package com.cs50.skiresortinfo.repository;

import com.cs50.skiresortinfo.domain.Resort;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Properties;

public class ResortsJdbcRepository implements ResortsRepository {

    private static final String POSTGRES_DATABASE_URL = "jdbc:postgresql://localhost:5432/resorts";

    private static final String POSTGRES_USER = getSecret("postgres.username");

    private static final String POSTGRES_PASSWORD = getSecret("postgres.password");


    private static final String INSERT_RESORT = """
        INSERT INTO resorts (slug, name, country, region, url, latitude, longitude)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        ON CONFLICT (slug) DO UPDATE SET name = EXCLUDED.name, country = EXCLUDED.country,
         region = EXCLUDED.region, url = EXCLUDED.url,
         latitude = EXCLUDED.latitude, longitude = EXCLUDED.longitude
        """;

    private static final String SELECT_RESORT = """
        SELECT * FROM resorts WHERE name = ?
        """;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load PostgreSQL JDBC driver", e);
        }
    }

    @Override
    public void saveResort(Resort resort) {
        try (Connection connection = DriverManager.getConnection(POSTGRES_DATABASE_URL, POSTGRES_USER, POSTGRES_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(INSERT_RESORT);
            statement.setString(1, resort.slug());
            statement.setString(2, resort.name());
            statement.setString(3, resort.country());
            statement.setString(4, resort.region());
            statement.setString(5, resort.url());
            statement.setDouble(6, resort.latitude());
            statement.setDouble(7, resort.longitude());
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Failed to save" + resort, e);
        }
    }

    @Override
    public List<Resort> getAllResorts() {
        try (Connection connection = DriverManager.getConnection(POSTGRES_DATABASE_URL, POSTGRES_USER, POSTGRES_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM resorts");
            List<Resort> resorts = new ArrayList<>();
            while (resultSet.next()) {
                Resort resort = new Resort(resultSet.getString("slug"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("region"),
                        resultSet.getString("url"),
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude"));
                resorts.add(resort);
            }
            return Collections.unmodifiableList(resorts);
        } catch (SQLException e) {
            throw new RepositoryException("Failed to get all resorts", e);
        }
    }

    @Override
    public Resort getResort(String name) {
        try (Connection connection = DriverManager.getConnection(POSTGRES_DATABASE_URL, POSTGRES_USER, POSTGRES_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(SELECT_RESORT);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Resort(resultSet.getString("slug"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("region"),
                        resultSet.getString("url"),
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RepositoryException("Failed to get resort", e);
        }
    }

    private static String getSecret(String s) {
        try (InputStream propertiesStream =
                     ResortsJdbcRepository.class.getResourceAsStream("/database.properties")) {
            Properties properties = new Properties();
            properties.load(propertiesStream);
            return properties.getProperty(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
