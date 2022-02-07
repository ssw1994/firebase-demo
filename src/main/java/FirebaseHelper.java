import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class FirebaseHelper {
    public static void main(String args[])  {
        try{
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl("https://fir-messaging-bf2db.firebaseio.com")
                    .build();

            FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
            Firestore firestore = FirestoreOptions.getDefaultInstance().getService();

            Message msg = new Message("a","b","c");
            ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("messages").document("test_dd3").set(msg);
            System.out.println(collectionsApiFuture.get().getUpdateTime().toString());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
