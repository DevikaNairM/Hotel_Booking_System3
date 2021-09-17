package com.infy.controller;

import com.couchbase.client.java.Cluster;
import com.infy.model.Configuration;
import com.infy.model.Queries;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertFalse;

public class ConnectionTest {

    Connection connection;
    Cluster cluster;
    @BeforeEach
    public void setup() {
        connection=new Connection();
        System.out.println("Instantiating Connection");
        connection.connect(Configuration.connectionString,Configuration.username,Configuration.password,Configuration.bucketName);

    }


    @Test
    public void testAdd() {
        assertFalse(connection.add(cluster, Queries.query1));
    }


    @Test
    @DisplayName("Should Not Create connection when parameters are null")
    public void shouldThrowRuntimeExceptionWhenParameterNull() {
        Assertions.assertThrows(RuntimeException.class, () -> connection.connect(Configuration.connectionString,Configuration.username,Configuration.password,""));
    }
}

