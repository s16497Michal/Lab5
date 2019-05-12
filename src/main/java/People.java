import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class People {

    private List<Person> people;

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
