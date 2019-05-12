import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class PersonClient {

    public static final String URL = "http://localhost:8080/samplerestapp/rest/people";

    public int postPerson(Person person) {
        return ClientBuilder.newClient().target(URL).request().post(Entity.entity(person, MediaType.APPLICATION_JSON))
                .getStatus();
    }
}
