package com.infy.controller;

import com.couchbase.client.core.env.TimeoutConfig;
import com.couchbase.client.java.*;
import com.couchbase.client.java.env.ClusterEnvironment;
import com.couchbase.client.java.query.QueryResult;
import com.infy.model.Configuration;
import com.infy.model.Queries;

import java.time.Duration;

public class Connection  implements Queries {

        public Cluster connect(String connectionName, String UserName,String password,String bucketName){
            if(connectionName==""|| UserName=="" || password==""|| bucketName=="")
                throw new RuntimeException("Parameter null");
            ClusterEnvironment env = ClusterEnvironment.builder()
                    .timeoutConfig(TimeoutConfig
                            .kvTimeout(Duration.ofSeconds(60))
                            .queryTimeout(Duration.ofSeconds(10)))
                    .build();
            ClusterOptions clusterOptions = ClusterOptions.clusterOptions(Configuration.username, Configuration.password);
            clusterOptions.environment(env);
            Cluster cluster = Cluster.connect(Configuration.connectionString, clusterOptions);
            // get a bucket reference
            Bucket bucket = cluster.bucket(Configuration.bucketName);
            bucket.waitUntilReady(Duration.ofSeconds(60));
            // get a user defined collection reference
            Scope scope = bucket.scope("_default");
            Collection collection = scope.collection("_default");
            return  cluster;
        }

        public boolean add(Cluster cluster, String query1){
            try {
                if(cluster==null || query1=="")
                    return false;
                else {
                    QueryResult result = cluster.query(query1);
                    System.out.println(result.rowsAsObject());
                    return true;
                }
            }catch (Exception e){
                System.out.println(e);
                return false;
            }
        }
}
