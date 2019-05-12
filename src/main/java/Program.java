

public class Program {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("jan");
        p.setSurname("kowalski");
        PersonClient client = new PersonClient();
        System.out.println(client.postPerson(p));
    }
}
