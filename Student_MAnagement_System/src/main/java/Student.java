import com.couchbase.client.java.Cluster;
import com.infy.controller.Connection;
import com.infy.model.Configuration;
import com.infy.model.Queries;


public class Student {
    public static void main(String[] args) {
        Connection c=new Connection();
        Cluster cluster= c.connect(Configuration.connectionString,Configuration.username,Configuration.password,Configuration.bucketName);
        if(cluster!=null  ){
            System.out.println("Connection success");
            c.add(cluster, Queries.query1);
            c.add(cluster,Queries.query2);
            c.add(cluster,Queries.query3);

        }

    }
}
