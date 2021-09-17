import Gradle_CouchBase_Demo.model.Configuration;
import com.couchbase.client.core.env.TimeoutConfig;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.env.ClusterEnvironment;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.*;
import com.couchbase.client.java.kv.*;
import com.couchbase.client.java.query.*;

import java.time.Duration;

public class CouchBase implements Configuration {

    public static void main(String[] args) {

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

        {
            MutationResult upsertResult = collection.upsert(
                    "5",
                    JsonObject.create().put("name", "Manoj")
            );

            GetResult getResult = collection.get("5");
            System.out.println(getResult);
            String name = getResult.contentAsObject().getString("name");
            System.out.println("Name:" + name); // name == "Manoj"
            QueryResult result = cluster.query("select \"Hello World\" as greeting");
            System.out.println(result.rowsAsObject());
        }

        {
            // Upsert Document
            MutationResult upsertResult = collection.upsert(
                    "my-document",
                    JsonObject.create().put("name", "mike").put("Salary",120000)

            );

            // Get Document
            GetResult getResult = collection.get("my-document");
            String name = getResult.contentAsObject().getString("name");
            System.out.println(name); // name == "mike"

            QueryResult result = cluster.query("select * from Employee");
            System.out.println(result.rowsAsObject());

            QueryResult result2=cluster.query("upsert into Employee(key,value)values(\"6\",{\"Name\":\"Divya\",\"Email\":\"Divya@gmail.com\",\"Salary\":21000})");
            System.out.println(result2.rowsAsObject());

            QueryResult result3 = cluster.query("select * from Employee");
            System.out.println(result3.rowsAsObject());
        }
    }

}



