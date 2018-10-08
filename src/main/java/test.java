

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class test {
	private static final String APP_NAME = "Google Drive API";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	// Directory to store user credentials for this application.
    private static final java.io.File CREDENTIAL_DIRECTORY //
            = new java.io.File(System.getProperty("user.home"), "credentials");
    private static final String CLIENT_SECRET_JOSON_FILE_NAME = "client_secret_json.json";
    //
    // Global instance of the scopes required by this quickstart. If modifying these
    // scopes, delete your previously saved credentials/ folder.
    //
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
    	 
        java.io.File clientSecretFilePath = new java.io.File(CREDENTIAL_DIRECTORY, CLIENT_SECRET_JOSON_FILE_NAME);
 
        if (!clientSecretFilePath.exists()) {
            throw new FileNotFoundException("Please copy " + CLIENT_SECRET_JOSON_FILE_NAME //
                    + " to folder: " + CREDENTIAL_DIRECTORY.getAbsolutePath());
        }
        // Load client secrets.
        InputStream in = new FileInputStream(clientSecretFilePath);
 
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
 
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
                clientSecrets, SCOPES).setDataStoreFactory(new FileDataStoreFactory(CREDENTIAL_DIRECTORY))
                        .setAccessType("offline").build();
 
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }
 
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		System.out.println("CREDENTIALS_FOLDER: " + CREDENTIAL_DIRECTORY.getAbsolutePath());
		 
        // 1: Create CREDENTIALS_FOLDER
		if (!CREDENTIAL_DIRECTORY.exists()) {
            CREDENTIAL_DIRECTORY.mkdirs();
 
            System.out.println("Created Folder: " + CREDENTIAL_DIRECTORY.getAbsolutePath());
            System.out.println("Copy file " + CLIENT_SECRET_JOSON_FILE_NAME + " into folder above.. and rerun this class!!");
            return;
        }
		 // 2: Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
 
        // 3: Read client_secret.json file & create Credential object.
        Credential credential = getCredentials(HTTP_TRANSPORT);
 
        // 5: Create Google Drive Service.
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential) //
                .setApplicationName(APP_NAME).build();
 
        // Print the names and IDs for up to 10 files.
        FileList result = service.files().list().setPageSize(10).setFields("nextPageToken, files(id, name)").execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
        }
		
	}

}
